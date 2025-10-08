import java.util.*;

class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Graph Creation
        List<List<Pair>> adj = createGraph(n, m, edges);
        
        if(m == 0) return Arrays.asList(-1);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] par = new int[n+1];
        for(int i = 0; i <= n; i++) {
            par[i] = i;  
        }
                
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));
        
        dist[1] = 0;
        pq.offer(new Pair(1, 0));
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currDist = curr.wt;
            
            if(currDist > dist[currNode]) continue;
            
            for(Pair neighPair : adj.get(currNode)) {
                int neigh = neighPair.node;
                int neighDist = neighPair.wt;
                int newDist = currDist + neighDist;
                
                if(newDist < dist[neigh]) {
                    dist[neigh] = newDist;
                    par[neigh] = currNode;
                    pq.offer(new Pair(neigh, newDist));
                } 
            }
        }
        
        // CHECK IF NODE n IS REACHABLE BEFORE PATH RECONSTRUCTION
        if(dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }
        
        // Reconstruct path from n to 1
        List<Integer> ans = new ArrayList<>();
        int node = n;
        while(node != 1) {
            ans.add(node);
            node = par[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        
        // Add total distance at the beginning if required
        ans.add(0, dist[n]);
        
        return ans;
    }
    
    public List<List<Pair>> createGraph(int n, int m, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        return adj;
    }
}

class Pair {
    int node, wt;
    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}