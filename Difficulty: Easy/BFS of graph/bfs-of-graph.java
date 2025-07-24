class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean [] vis = new boolean [n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            vis[curr] = true;
            
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