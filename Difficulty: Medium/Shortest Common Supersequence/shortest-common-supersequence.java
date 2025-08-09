// User function Template for Java

class Solution {
    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int n = s1.length();
        int m = s2.length();
        
        int [] [] dp = new int [n+1][m+1];
        for(int [] a : dp) {
            Arrays.fill(a , -1);
        }
        
        int val = dfs(n, m, s1, s2, dp);
        
        return n+m-val;
    }
    
    static int dfs(int n , int m , String s1 , String s2 , int [] [] dp) {
        if(n < 0 || m < 0) return -1;
        
        if(n==0 || m==0) return 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return dp[n][m] =  1 + dfs(n-1 , m-1 , s1 , s2 , dp);    
        }
        else {
            int val1 = dfs(n-1 , m , s1 ,s2 , dp);
            int val2 = dfs(n , m-1 , s1 ,s2 , dp);
            
            return dp[n][m] =  Math.max(val1,val2);
        }
    }
}