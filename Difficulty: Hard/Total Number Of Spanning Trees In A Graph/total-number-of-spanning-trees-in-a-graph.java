//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            
            int[][] graph = IntMatrix.input(br, a[1], 2);
            
            Solution obj = new Solution();
            int res = obj.countSpanningTrees(graph,a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int countSpanningTrees(int[][] graph, int n, int m) {
        int[][] laplacian = new int[n][n];
        
        // Construct the Laplacian matrix
        for (int[] edge : graph) {
            int sv = edge[0];
            int ev = edge[1];
            
            laplacian[sv][sv]++;
            laplacian[ev][ev]++;
            
            laplacian[sv][ev]--;
            laplacian[ev][sv]--;
        }
        
        // Remove the last row and last column to get the (n-1)x(n-1) matrix
        int[][] minor = new int[n-1][n-1];
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                minor[i][j] = laplacian[i][j];
            }
        }
        
        // Return the determinant of the minor matrix
        return determinant(minor);
    }
    
    private static int determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        
        int det = 0;
        for (int i = 0; i < n; i++) {
            det += Math.pow(-1, i) * matrix[0][i] * determinant(minor(matrix, 0, i));
        }
        return det;
    }
    
    private static int[][] minor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n-1][n-1];
        for (int i = 0, r = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0, c = 0; j < n; j++) {
                if (j == col) continue;
                minor[r][c++] = matrix[i][j];
            }
            r++;
        }
        return minor;
    }
}

