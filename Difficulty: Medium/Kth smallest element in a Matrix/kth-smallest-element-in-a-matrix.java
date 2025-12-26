class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int low = mat[0][0];
        int high = mat[n - 1][m - 1];
        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (countLessEqual(mat, mid) >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int countLessEqual(int[][] mat, int val) {
        int n = mat.length;
        int m = mat[0].length;

        int row = n - 1;
        int col = 0;
        int count = 0;

        // Staircase traversal
        while (row >= 0 && col < m) {
            if (mat[row][col] <= val) {
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
