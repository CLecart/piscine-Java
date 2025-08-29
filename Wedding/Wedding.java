import java.util.*;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        if (first == null || second == null) return Collections.emptyMap();

        List<String> left = new ArrayList<>();
        for (String s : first) if (s != null) left.add(s);

        List<String> right = new ArrayList<>();
        for (String s : second) if (s != null) right.add(s);

        Collections.shuffle(right);
        Iterator<String> it = right.iterator();

        Map<String, String> result = new LinkedHashMap<>();
        for (String f : left) {
            if (!it.hasNext()) break;
            result.put(f, it.next());
        }
        return result;
    }
}