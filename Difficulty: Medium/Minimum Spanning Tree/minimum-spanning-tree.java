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
    // Prim's algorithm has O(ElogV) time complexity and O(V + E) space complexity.
    // It uses a priority queue to efficiently select the minimum-weight edge. 
    // The space complexity is linear due to the adjacency list representation and the priority queue. 
    // Prim's algorithm is efficient for sparse graphs but can be slower than Kruskal's for dense graphs. 
    // It's implemented using a disjoint-set data structure to avoid revisiting vertices. 
    // The algorithm runs in O(ElogE) time when using binary heaps for the priority queue. 
    // For Fibonacci heaps, it can achieve O(E + VlogV) time complexity.
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Create a priority queue to store vertices based on their edge weights
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        // To track visited vertices
        boolean [] vis = new boolean[V];
        
        // Start from vertex 0 (it can be any arbitrary starting point)
        pq.add(new int[]{0, 0});  // {vertex, weight}

        int ans = 0;
        
        while(!pq.isEmpty()) {
            int [] curr = pq.poll();
            
            int currNode = curr[0];
            int currWt   = curr[1];
            
            if(vis[currNode]) continue;
            
            vis[currNode] = true;
            
            ans += currWt;
            
            List<int[]> neighList = adj.get(currNode);
            
            for(int [] neigh : neighList) {
                int neighNode = neigh[0];
                int neighWt = neigh[1];
                
                if(!vis[neighNode]) {
                    pq.add(new int [] {neighNode , neighWt});
                }
            }
        }
        
        return ans;
    }
}