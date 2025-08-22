class Solution {
    public int median(int[][] mat) {
       int n = mat.length;
        int m = mat[0].length;

        // Find min and max in the matrix
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, mat[i][0]);        // first element of row
            max = Math.max(max, mat[i][m - 1]);    // last element of row
        }

        int desired = (n * m + 1) / 2; // position of median

        while (min < max) {
            int mid = min + (max - min) / 2;

            // Count how many numbers <= mid
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmallerEqual(mat[i], mid);
            }

            if (count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min; // or max (both converge)
    }

    // Binary search in a sorted row
    private int countSmallerEqual(int[] row, int target) {
        int l = 0, r = row.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; // number of elements <= target
    }
}