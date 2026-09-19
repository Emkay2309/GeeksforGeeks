class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        // code here
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lcs = lcs(s1, s2, n - 1, m - 1, dp);

        int deleteFromS1 = n - lcs;
        int deleteFromS2 = m - lcs;

        return deleteFromS1 * costS1 + deleteFromS2 * costS2;
    }
    
    public int lcs(String s1, String s2, int i, int j, int[][] dp) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        }

        return dp[i][j] = Math.max(
            lcs(s1, s2, i - 1, j, dp),
            lcs(s1, s2, i, j - 1, dp)
        );
    }

}