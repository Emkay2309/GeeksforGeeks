class Solution {
    ArrayList<Integer> ans;
    boolean [] vis;
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ans = new ArrayList<>();
        vis = new boolean [adj.size()];
        bfsSolve(adj);
        return ans;
    }
    
    public void bfsSolve(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            vis[curr] = true;
            ans.add(curr);
            
            for(int neigh : adj.get(curr)) {
                if(!vis[neigh]) {
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }
    }
}