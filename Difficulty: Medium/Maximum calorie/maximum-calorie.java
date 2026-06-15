class Solution {
    public int maxCalories(int arr[], int n) {
        if (n == 1) return arr[0];
        if (n == 2) return arr[0] + arr[1];
        if (n == 3) return Math.max(arr[0] + arr[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
        
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0] + arr[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
        
        for (int i = 3; i < n; i++) {
            int one = arr[i] + arr[i-1] + dp[i-3];
            int two = arr[i] + dp[i-2];
            int three = dp[i-1];
            dp[i] = Math.max(one, Math.max(two, three));
        }
        
        return dp[n-1];
    }
}