import java.util.*;

class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[][][] dp = new int[n][m][k + 1];
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        return intPaths(mat, k, 0, 0, mat[0][0], n, m, dp);
    }

    public int intPaths(int[][] mat, int k, int i, int j, int sum, int n, int m, int[][][] dp) {
        // If current sum exceeds k, stop early
        if (sum > k) return 0;

        // If we reached bottom-right cell
        if (i == n - 1 && j == m - 1) {
            return (sum == k) ? 1 : 0;
        }

        if (dp[i][j][sum] != -1) return dp[i][j][sum];

        int right = 0;
        int down = 0;

        // Move Right
        if (j + 1 < m)
            right = intPaths(mat, k, i, j + 1, sum + mat[i][j + 1], n, m, dp);

        // Move Down
        if (i + 1 < n)
            down = intPaths(mat, k, i + 1, j, sum + mat[i + 1][j], n, m, dp);

        return dp[i][j][sum] = right + down;
    }
}
