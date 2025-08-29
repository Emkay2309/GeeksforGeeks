class Solution {
    public int celebrity(int[][] mat) {
        int n = mat.length;
        int cand = 0; // start with person 0

        // Step 1: Find potential candidate
        for (int i = 1; i < n; i++) {
            if (mat[cand][i] == 1) {
                // cand knows i → cand cannot be celebrity
                cand = i;
            }
            // else: cand does not know i → i cannot be celebrity
        }

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == cand) continue;
            if (mat[cand][i] == 1 || mat[i][cand] == 0) {
                return -1; // fails celebrity condition
            }
        }
        return cand;
    }
}
