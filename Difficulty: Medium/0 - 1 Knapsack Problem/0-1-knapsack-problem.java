class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int [][]dp = new int [n+1][W+1];
        
        for(int i=1 ; i<n+1 ; i++) {
            for(int j=1 ; j<W+1 ; j++) {
                int value = val[i-1];
                int weight = wt[i-1];
                
                //Valid Condition
                if(j >= weight) {
                    //include
                    int include = value + dp[i-1][j-weight];
                    
                    //exclude
                    int exclude = dp[i-1][j];
                    
                    dp[i][j] = Math.max(include , exclude);
                    
                }
                else {
                    //exclude
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;
                }
            }
        }
        return dp[n][W];
    }
}


