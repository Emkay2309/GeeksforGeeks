//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<List<Integer>> edges = new ArrayList<>();
        for(int sv=0; sv<V ; sv++) {
            for(int [] edge : adj.get(sv)) {
                int ev = edge[0];
                int wt = edge[1];
                
                edges.add(Arrays.asList(sv , ev , wt));
                
            }
        }
        Collections.sort(edges , (e1 , e2) -> Integer.compare( e1.get(2) , e2.get(2)));
        
        return Kruskal(edges , V);
    }
    
    static int Kruskal(List<List<Integer>> edges , int V) {
        int sum = 0;
        DSU dsu = new DSU (V);
        
        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            
            int up = dsu.find(u);
            int vp = dsu.find(v);
            
            if(up != vp) {
                dsu.union(u , v);
                sum += wt;
            }
        }
        return sum;
    }
}

class DSU {
    int [] par;
    int [] rank;
    
    DSU(int n) {
        par = new int [n];
        rank = new int [n];
        
        for(int i=0 ; i<n ; i++) {
            par[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int u) {
        if(u == par[u]) return u;
        return par[u] = find(par[u]);
    }
    
    public void union(int u , int v) {
        int up = find(u);
        int vp = find(v);
        
        if(up == vp) return;
        
        if(rank[up] > rank[vp]) {
            par[vp] = up; 
        }
        else if(rank[vp] > rank[up]) {
            par[up] = vp;
        }
        else {
            par[up] = vp;
            rank[vp]++;
        }
    }
}
