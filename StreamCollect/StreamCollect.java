import java.util.*;
import java.util.stream.*;

public class StreamCollect {
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        if (s == null) return Collections.emptyMap();
        return s.filter(Objects::nonNull)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.groupingBy(
                        str -> Character.toUpperCase(str.charAt(0)),
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        if (s == null) return Collections.emptyMap();
        return s.filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        i -> Math.floorMod(i, 4),
                        TreeMap::new,
                        Collectors.maxBy(Integer::compareTo)
                ));
    }

    public static String orderAndConcatWithSharp(Stream<String> s) {
        if (s == null) return "##{}";
        String joined = s.filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.joining(" # "));
        return "##{" + joined + "}";
    }
}