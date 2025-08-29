import java.util.*;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        if (first == null || second == null) return Collections.emptyMap();
        if (first.isEmpty() || second.isEmpty()) return Collections.emptyMap();

        // Build ranking for members of the second map: name -> (proposer -> rank)
        Map<String, Map<String, Integer>> ranking = new HashMap<>();
        for (Map.Entry<String, List<String>> e : second.entrySet()) {
            String s = e.getKey();
            List<String> prefs = e.getValue() == null ? Collections.emptyList() : e.getValue();
            Map<String, Integer> rank = new HashMap<>();
            for (int i = 0; i < prefs.size(); i++) {
                if (prefs.get(i) != null) rank.put(prefs.get(i), i);
            }
            ranking.put(s, rank);
        }

        // Next proposal index for each proposer from the first map
        Map<String, Integer> nextIndex = new HashMap<>();
        for (String f : first.keySet()) nextIndex.put(f, 0);

        // Queue of free proposers (respecting iteration order of the input map)
        Queue<String> free = new ArrayDeque<>();
        for (String f : first.keySet()) free.add(f);

        Map<String, String> partnerOfSecond = new HashMap<>(); // second -> first
        Map<String, String> partnerOfFirst = new HashMap<>();  // first -> second

        while (!free.isEmpty()) {
            String f = free.poll();
            List<String> prefs = first.getOrDefault(f, Collections.emptyList());
            int idx = nextIndex.getOrDefault(f, 0);
            if (idx >= prefs.size()) continue; // no one left to propose

            String s = prefs.get(idx);
            nextIndex.put(f, idx + 1);

            if (s == null || !second.containsKey(s)) {
                // invalid choice, continue to next preference
                if (nextIndex.getOrDefault(f, 0) < prefs.size()) free.add(f);
                continue;
            }

            String current = partnerOfSecond.get(s);
            if (current == null) {
                // s is free -> engage
                partnerOfSecond.put(s, f);
                partnerOfFirst.put(f, s);
            } else {
                // s compares current partner and new proposer f
                Map<String, Integer> ranks = ranking.getOrDefault(s, Collections.emptyMap());
                int rankF = ranks.getOrDefault(f, Integer.MAX_VALUE / 2);
                int rankCurrent = ranks.getOrDefault(current, Integer.MAX_VALUE / 2);
                if (rankF < rankCurrent) {
                    // s prefers f -> switch
                    partnerOfSecond.put(s, f);
                    partnerOfFirst.remove(current);
                    partnerOfFirst.put(f, s);
                    // previous partner becomes free if they still have preferences left
                    if (nextIndex.getOrDefault(current, 0) < first.getOrDefault(current, Collections.emptyList()).size()) {
                        free.add(current);
                    }
                } else {
                    // s rejects f -> f stays/free if has more preferences
                    if (nextIndex.getOrDefault(f, 0) < prefs.size()) free.add(f);
                }
            }
        }

        // Return mapping for proposers in the original iteration order
        Map<String, String> result = new LinkedHashMap<>();
        for (String f : first.keySet()) {
            if (partnerOfFirst.containsKey(f)) result.put(f, partnerOfFirst.get(f));
        }
        return result;
    }
}