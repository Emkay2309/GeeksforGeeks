class Solution{
    static int optimalKeys(int N){
        int[] dp = new int[N+1];
        
        dp[1] = 1;
        
        for(int i=2; i<=N; i++) {
            if(i<4) {
                dp[i] = dp[i-1] + 1;
            } else {
                int max = dp[i-1] + 1;
                int s = 2;
                for(int j = i-3; j>=1; j--) {
                    max = Math.max(max, s * dp[j]);
                    s++;
                }
                
                dp[i] = max;
            }
            
        }
        
        return dp[N];
    }
}