class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean [] vis = new boolean [n];
        
        for(int i=0; i<n ; i++) {
            if(!vis[i]) {
                dfs(i , vis , ans , adj);
            }
        }
        return ans;
    }
    
    public void dfs(int curr , boolean [] vis , ArrayList<Integer> ans , ArrayList<ArrayList<Integer>> adj) {
        vis[curr] = true;
        ans.add(curr);
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , ans , adj);
            }
        }
    }
}