import java.util.*;
import java.util.stream.*;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        if (amount <= 0) return Collections.emptyList();
        // filter out non-positive coins
        List<Integer> coinList = coins.stream()
                .filter(Objects::nonNull)
                .filter(c -> c > 0)
                .collect(Collectors.toList());
        if (coinList.isEmpty()) return Collections.emptyList();

        final int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[amount + 1];
        int[] prev = new int[amount + 1];
        Arrays.fill(dp, INF);
        Arrays.fill(prev, -1);
        dp[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int c : coinList) {
                if (c <= a && dp[a - c] + 1 < dp[a]) {
                    dp[a] = dp[a - c] + 1;
                    prev[a] = c;
                }
            }
        }

        if (dp[amount] >= INF) return Collections.emptyList(); // no solution

        List<Integer> result = new ArrayList<>();
        int cur = amount;
        while (cur > 0) {
            int c = prev[cur];
            if (c <= 0) break; // safety
            result.add(c);
            cur -= c;
        }

        // return coins in descending order (matches expected formatting)
        result.sort(Comparator.reverseOrder());
        return result;
    }
}