
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<V ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int [] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean [] vis = new boolean [V];
        
        for(int i=0 ; i<V ; i++) {
            if(!vis[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                dfs(i , vis , temp , adj);
                ans.add(temp);
            }
        }
        return ans;
    }
    
    public void dfs(int curr , boolean [] vis , ArrayList<Integer> ans , ArrayList<ArrayList<Integer>> adj ) {
        vis[curr] = true;
        ans.add(curr);
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , ans , adj);
            }
        }
    }
}