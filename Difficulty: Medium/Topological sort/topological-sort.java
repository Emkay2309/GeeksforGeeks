class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = createAdj(V , edges);
        boolean [] vis = new boolean [V];
        Stack<Integer> st = new Stack<>();
        
        
        for(int i=0 ; i<V ; i++) {
            if(!vis[i]) {
                dfs( i , vis , st , adj);
            }
        }
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }
    
    public static void dfs(int curr , boolean [] vis , Stack<Integer> st , List<List<Integer>> adj) {
        vis[curr] = true;
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , st , adj);
            }
        }
        st.push(curr);
    }
    
    
    
    public static List<List<Integer>> createAdj( int n , int [][]edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); 
        }
        for(int e [] : edges) {
            adj.get(e[0]).add(e[1]);
        }
        return adj;
    }
}