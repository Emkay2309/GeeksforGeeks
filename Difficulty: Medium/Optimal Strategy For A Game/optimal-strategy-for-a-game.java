
class Solution {
    public int maximumAmount(int arr[]) {
        // code here
         int n = arr.length;
        int dp[][] = new int[n][n];
        
        return solve(arr, 0, n-1, dp);
    }
    
    int solve(int arr[], int i, int j, int dp[][]){
        if(i>j) return 0;
        
        if(dp[i][j]>0) return dp[i][j];
        
        int left = arr[i]+ Math.min(solve(arr, i+1, j-1, dp), solve(arr, i+2, j, dp));
        
        int right = arr[j] + Math.min(solve(arr, i+1, j-1, dp), solve(arr, i, j-2, dp));
        
        return dp[i][j] = Math.max(left, right);
        
    }
}
