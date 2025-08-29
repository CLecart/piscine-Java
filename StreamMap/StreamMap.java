import java.util.*;
import java.util.stream.*;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        if (s == null) return 0;
        int sum = s.filter(Objects::nonNull)
                .mapToInt(String::length)
                .sum();
        return Integer.valueOf(sum);
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        if (s == null) return Collections.emptyList();
        return s.filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        if (s == null) return Collections.emptySet();
        return s.filter(Objects::nonNull)
                .filter(d -> d > 42)
                .map(Double::intValue)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}