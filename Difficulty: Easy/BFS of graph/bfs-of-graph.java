class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean [] vis = new boolean [adj.size()];
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
        return ans;
    }
}