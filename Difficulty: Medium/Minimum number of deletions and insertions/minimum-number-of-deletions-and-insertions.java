//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution  {
	public int minOperations(String str1, String str2)  { 
	    int n = str1.length();
	    int m = str2.length();
	    
	    //int len = lcs(n,m,str1,str2);
	    int [][] dp = new int [n][m];
	    for(int [] a : dp) {
	        Arrays.fill(a , -1);
	    }
	    dfs(0 , 0 , n , m, str1 , str2 , dp);
	    int len = dp[0][0];
	    
	    int del = n - len;
	    int add = m - len;
	    
	    return del + add;
	} 
	
	public int dfs (int i , int j , int n , int m , String s1 , String s2 , int [][] dp) {
	    if(i >= n || j >= m) return 0;
	    
	    if(dp[i][j] != -1) return dp[i][j];
	    
	    char c1 = s1.charAt(i);
	    char c2 = s2.charAt(j);
	    
	    if(c1 == c2) {
	        dp[i][j] = 1 + dfs(i+1 , j+1 , n , m , s1 , s2 , dp);
	    }
	    else {
	        dp[i][j] = Math.max( dfs(i+1 , j , n , m , s1 , s2 , dp) , dfs(i , j+1 , n , m , s1 , s2 , dp));
	    }
	    
	    return dp[i][j];
	}
	
	public int lcs(int n , int m , String s1 , String s2 ) {
	    int [][] dp = new int [n+1][m+1];
	    
	    for(int i=1 ; i<=n ; i++) {
	        for(int j=1 ; j<=m ; j++) {
	            char c1 = s1.charAt(i-1);
	            char c2 = s2.charAt(j-1);
	            
	            //if the  characters are same so add 1 as
	           // we got a common character
	           if(c1 == c2) {
	               dp[i][j] = 1 + dp[i-1][j-1];
	           }
	           else {
	               dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
	           }
	        }
	    }
	    return dp[n][m];
	}
}