import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null || list.isEmpty()) return null;
        int idx = list.lastIndexOf(value);
        return idx == -1 ? null : idx;
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null || list.isEmpty()) return null;
        int idx = list.indexOf(value);
        return idx == -1 ? null : idx;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        if (list == null || list.isEmpty()) return java.util.Collections.emptyList();
        List<Integer> indexes = new java.util.ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                indexes.add(i);
            }
        }
        return indexes.isEmpty() ? null : indexes;
    }
}