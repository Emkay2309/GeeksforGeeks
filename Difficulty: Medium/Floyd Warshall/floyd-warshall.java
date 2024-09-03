//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


//User function template for JAVA

class Solution  {
    public void shortest_distance(int [][] matrix)   {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=0; i<n ; i++) {
            for(int j=0; j<m ; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 1001;
                }
            }
        }
        
        for(int via=0 ; via<n ; via++) {
            for(int sv=0; sv<n ; sv++) {
                for(int ev=0; ev<m ; ev++) {
                    int via1 = matrix[sv][via];
                    int via2 = matrix[via][ev];
                    
                    int totalVia = via1 + via2;
                    
                    int curr = matrix[sv][ev];
                    
                    matrix[sv][ev] = Math.min( curr , totalVia );
                }
            }
        }
        
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(matrix[i][j] == 1001) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}