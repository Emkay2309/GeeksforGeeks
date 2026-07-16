class Solution{
    private static long mod = 1000000007;
    static long countWays(int n, int sum)
    {
        // code here
        long[][] dp = new long[n][sum];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        long answer = 0;
        for (int i = 1; i <= Math.min(9, sum); i++) {
            answer += countWays(n - 1, sum - i, dp);
            answer %= mod;
        }
        return answer == 0 ? -1 : answer;
    }
    
    private static long countWays(int n, int sum, long[][] dp) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        if (sum > n * 9) {
            return 0;
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        long count = 0;
        for (int i = 0; i <= Math.min(9, sum); i++) {
            count += countWays(n - 1, sum - i, dp);
            count %= mod;
        }
        dp[n][sum] = count;
        return count;
    }
}