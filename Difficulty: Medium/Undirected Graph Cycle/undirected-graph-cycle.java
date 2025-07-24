class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int n = edges.length;
        boolean [] vis = new boolean [V];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int [] val : edges) {
            int u = val[0];
            int v = val[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i=0 ; i<V ; i++) {
            if(!vis[i]) {
                if(dfs(i,-1,vis,adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int curr , int par , boolean [] vis , ArrayList<ArrayList<Integer>> adj) {
        vis[curr] = true;
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh] ) {
                boolean check = dfs( neigh , curr , vis , adj);
                if(check) return true;
            }
            else if(par != neigh) {
                return true;
            }
        }
        return false;
    }
}