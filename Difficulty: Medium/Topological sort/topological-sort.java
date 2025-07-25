class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int a [] : edges) {
            int u = a[0];
            int v = a[1];
            adj.get(u).add(v);
        }
        
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                if(dfs(adj, i, vis, pathVis, stack)) {
                    return new ArrayList<>();
                }
            }
        }
        
        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        
        return ans;
    }
    
    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, boolean[] pathVis, Stack<Integer> stack) {
        vis[node] = true;
        pathVis[node] = true;
        
        for(int neigh : adj.get(node)) {
            if(!vis[neigh]) {
                if(dfs(adj, neigh, vis, pathVis, stack)) {
                    return true;
                }
            } else if(pathVis[neigh]) {
                // Cycle detected
                return true;
            }
        }
        
        // Backtrack
        pathVis[node] = false;
        // Push to stack when all neighbors are processed
        stack.push(node);
        return false;
    }
}