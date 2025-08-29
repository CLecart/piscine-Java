import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        return sortedList;
    }
    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList, Collections.reverseOrder());
        return sortedList;
    }
}


