class Solution {
    public boolean wildCard(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        
        // Create DP table
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        // Empty pattern matches empty text
        dp[0][0] = true;
        
        // Handle patterns starting with '*'
        for (int j = 1; j <= m; j++) {
            if (pat.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char textChar = txt.charAt(i - 1);
                char patternChar = pat.charAt(j - 1);
                
                if (patternChar == '*') {
                    // '*' can match:
                    // 1. Zero characters (dp[i][j-1])
                    // 2. One or more characters (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } 
                else if (patternChar == '?' || textChar == patternChar) {
                    // '?' matches any single character, or characters match exactly
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // else remains false
            }
        }
        
        return dp[n][m];
    }
}