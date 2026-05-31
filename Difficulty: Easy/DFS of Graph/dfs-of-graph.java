class Solution {
    ArrayList<Integer> ans;
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ans = new ArrayList<>();
        int n = adj.size();
        boolean [] vis = new boolean [n];
        
        for(int i=0 ; i<n ; i++) {
            if(!vis[i]) dfs(i, vis , adj);
        }
        return ans;
    }
    
    public void dfs(int curr , boolean [] vis , ArrayList<ArrayList<Integer>> adj) {
        vis[curr] = true;
        ans.add(curr);
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) dfs(neigh , vis , adj);
        }
    }
}