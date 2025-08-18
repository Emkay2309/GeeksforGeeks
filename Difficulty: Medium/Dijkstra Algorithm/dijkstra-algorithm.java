class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<ArrayList<Integer>>> adj = create( V , edges);
        int [] dist = new int [V];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0;
        boolean [] vis = new boolean [V];
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingDouble(a->a[1]));
        pq.add(new int [] {src , 0});
        
        
        while(!pq.isEmpty()) {
            int [] curr = pq.poll();
            int currNode = curr[0];
            int currWt = curr[1];
            
            if(vis[currNode]) continue;
            vis[currNode] = true;
            
            ArrayList<ArrayList<Integer>> neighList = adj.get(currNode);
            
            for(ArrayList<Integer> neigh : neighList) {
                int neighNode = neigh.get(0);
                int neighWt = neigh.get(1);
                
                if(dist[neighNode] > dist[currNode] + neighWt ) {
                    dist[neighNode] =  dist[currNode] + neighWt;
                    pq.add(new int [] {neighNode , dist[neighNode]});
                }
            }
        }
        return dist;
    }
    
    public ArrayList<ArrayList<ArrayList<Integer>>> create(int n , int [][] edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int [] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            
            adj.get(u).add(new ArrayList<>(Arrays.asList(v,wt)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u,wt)));
        }
        return adj;
    }
}