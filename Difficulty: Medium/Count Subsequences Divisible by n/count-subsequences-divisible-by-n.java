class Solution {
    static final int MOD = 1000000007;

    public int countSubsequences(String s, int n) {

        int[] dp = new int[n];

        for (char ch : s.toCharArray()) {

            int digit = ch - '0';

            int[] next = dp.clone();

            // Single digit subsequence
            next[digit % n]++;

            // Add current digit to all existing subsequences
            for (int rem = 0; rem < n; rem++) {

                int newRem = (rem * 10 + digit) % n;

                next[newRem] += dp[rem];

                if (next[newRem] >= MOD) {
                    next[newRem] -= MOD;
                }
            }

            dp = next;
        }

        return dp[0];
    }
}