class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj  = createAdj(V , edges);
        Queue<Integer> q = new LinkedList<>();
        int [] inDegree = new int [V];
        
        for(int [] e : edges) {
            inDegree[e[1]]++;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<V ; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            
            for(int neigh : adj.get(curr)) {
                inDegree[neigh]--;
                if(inDegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
        return ans;
    }
    
    public static List<List<Integer>> createAdj(int n , int [][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int [] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        return adj;
    }
}