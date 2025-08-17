class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = create( V , edges);
        int [] colors = new int [V];
        Arrays.fill(colors, -1);
        
        for(int i=0 ; i<V ; i++) {
            if(colors[i] == -1) {
                if(!dfs(i , 0 , colors , adj)) return false;
            }
        }
        return true;
    }
    
    
    public boolean dfs(int curr , int cc , int [] color , List<List<Integer>> adj) {
        color[curr] = cc;
        
        for(int neigh : adj.get(curr)) {
            if(color[neigh] == color[curr]) return false;
            if(color[neigh] == -1) {
                if(dfs( neigh , 1-cc , color , adj) == false) return false;
            }
        }
        return true;
    }
    
    public List<List<Integer>> create(int n , int [][] edge) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int e [] : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    } 
}