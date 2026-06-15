class Solution {
     private int solve(int i,int w,int[] costs,int[][] dp) {
        int n=costs.length;
        if(i==n){
            if(w==0)return 0;
            else return Integer.MAX_VALUE/2;
        }
        
        if(w<0)return Integer.MAX_VALUE/2;
        
        if(dp[i][w]!=-1)return dp[i][w];
        
        int nottake=solve(i+1,w,costs,dp);
        int take=Integer.MAX_VALUE;
        
        if(costs[i]!=-1)take=solve(i,w-(i+1),costs,dp)+costs[i];
        
        return dp[i][w]=Math.min(take,nottake);
        
    }
    public int minimumCost(int[] cost, int w) {
        // code here
        
        int sum=0;
        for(int i:cost) sum+=i;
        
        int[][] dp = new int[cost.length][w+1];
        
        for(int[] row:dp)   Arrays.fill(row,-1);
        
        int result = solve(0,w,cost,dp);
        
        if(result>sum*w)    return -1;
        return result;
    }
}