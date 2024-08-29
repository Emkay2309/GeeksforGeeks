//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends

class Solution  {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)   {
        boolean [] vis = new boolean [V];
        Stack<Integer> st = new Stack();
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        
        for(int i=0 ; i<V ; i++) {
            if(!vis[i]) {
                dfs(i , vis , true , st , adj);
            }
            rev.add(new ArrayList<>());   
        }
        
        // Reverse the graph and run dfs if !vis
        for(int sv=0 ; sv<V ; sv++) {
            for(int ev : adj.get(sv)) {
                rev.get(ev).add(sv);
            }
        }
        
        int ans = 0;
        vis = new boolean [V];
        
        while(!st.isEmpty()) {
            int curr = st.pop();
            
            if(!vis[curr]) {
                dfs(curr , vis , false , st , rev);
                ans++;
            }
        }
        
        return ans;
    }
    
    public void dfs(int curr , boolean [] vis , boolean flag , Stack<Integer> st , ArrayList<ArrayList<Integer>> adj) {
        vis[curr] = true;
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , flag , st , adj);
            }
        }
        if(flag) {
            st.push(curr);
        }
    }
}
