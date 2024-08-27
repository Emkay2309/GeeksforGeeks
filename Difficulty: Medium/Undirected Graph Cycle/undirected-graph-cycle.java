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
        boolean [] vis = new boolean [V];
        
        
        for(int i=0 ; i<V ; i++) {
            if(!vis[i]) {
                if (bfs(i,vis,adj) ) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfs(int src , boolean [] vis , ArrayList<ArrayList<Integer>> adj) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        
        vis[src] = true;
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int currNode = curr.node;
            int currPar = curr.par;
            
            for(int neigh : adj.get(currNode)) {
                if(neigh == currPar) continue;
                if(!vis[neigh]) {
                    q.add(new Pair(neigh , currNode));
                    vis[neigh] = true;
                }
                else if(neigh != currPar) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

class Pair {
    int node;
    int par;
    
    Pair(int node , int par) {
        this.node = node;
        this.par = par;
    }
}