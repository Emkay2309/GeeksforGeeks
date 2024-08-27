//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        par = new int [V];
        rank = new int [V];
        
        for(int i=0 ; i<V ; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        
        for(int u=0 ; u<V ; u++) {
            for(Integer v : adj.get(u)) {
                if( u < v) {
                    int par_u = find(u,par);
                    int par_v = find(v,par);
                    
                    if(par_u == par_v) return true;
                    
                    union(u , v , par , rank);
                }
            }
        }
        return false;
    }
    
    public int [] par;
    
    public int [] rank;
    
    public int find(int x , int [] par) {
        if( x == par[x] ) return x;
        return par[x] = find(par[x] , par);
    }
    
    public void union (int x, int y , int [] par , int [] rank ) {
        int a = find(x , par);
        int b = find(y , par);
        
        if(a == b) return;
        
        if(rank[a] > rank[b]) {
            par[b] = a;
        }
        else if(rank[a] < rank[b]) {
            par[a] = b;
        }
        else {
            par[a] = b;
            rank[b]++;
        }
    }
}