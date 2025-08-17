class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = createAdj(V , edges);
        boolean [] vis = new boolean [V];
        boolean [] rec = new boolean [V];    
        
        for(int i=0 ; i<V ; i++) {
            if(!vis[i]) {
                boolean check = dfs(i , rec, vis , adj);
                if(check) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int curr , boolean [] rec , boolean [] vis , List<List<Integer>> adj) {
        vis[curr] = true;
        rec[curr] = true;
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                if(dfs(neigh , rec , vis ,adj)) return true;
            }
            else if(rec[neigh]) {
                return true;
            } 
        }
        rec[curr] = false;
        return false;
    }
    
    
    
    public List<List<Integer>> createAdj(int n , int[][]edge) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int e [] : edge) {
            int sv = e[0];
            int ev = e[1];
            
            adj.get(sv).add(ev);
            //adj.get(ev).add(sv);
        }
        return adj;
    }
}