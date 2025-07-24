class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean [] vis = new boolean [adj.size()];
        
        for(int i=0 ; i<adj.size() ; i++) {
            if(!vis[i]) {
                dfs(i , vis , ans , adj);
            }    
        }
        return ans;
    }
    
    public void dfs(int curr, boolean [] vis , ArrayList<Integer> ans , ArrayList<ArrayList<Integer>> adj) {
        vis[curr] = true;
        ans.add(curr);
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , ans , adj);
            }
        }
    }
}