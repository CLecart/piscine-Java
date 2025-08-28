import java.util.List;

public class ListContains {
    public static boolean containsValue(List<Integer> list, Integer value) {
        if (list == null || value == null) {
            return false;
        }
        for (Integer item : list) {
            if (value.equals(item)) {
                return true;
            }
        }
        return false;
    }
}