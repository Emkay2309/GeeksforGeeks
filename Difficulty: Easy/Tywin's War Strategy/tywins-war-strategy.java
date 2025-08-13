import java.util.*;

class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int target = (n + 1) / 2; // ceil(n/2)

        // Count lucky troops
        int count = (int) Arrays.stream(arr)
                                .filter(a -> a % k == 0)
                                .count();

        if (count >= target) return 0; // already enough lucky troops

        // Compute extra soldiers needed for non-lucky troops
        List<Integer> extra = new ArrayList<>();
        for (int soldiers : arr) {
            if (soldiers % k != 0) {
                extra.add(k - (soldiers % k));
            }
        }

        // Sort the costs
        Collections.sort(extra);

        // Add up the smallest needed
        int needed = target - count;
        int total = 0;
        for (int i = 0; i < needed; i++) {
            total += extra.get(i);
        }

        return total;
    }
}
