import java.util.*;

class Solution {
    public int countTriangles(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    ans += (j - i);  // all pairs (i..j-1, j) work
                    j--;
                } else {
                    i++;
                }
            }
        }
        return ans;
    }
}
