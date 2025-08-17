class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = createAdj(V , edges);
        
        int [] indegree = new int [V];
        for(int [] e : edges) {
            indegree[e[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<V ; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int count = 0;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;
            
            for(int neigh : adj.get(curr)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
        
        if(count == V) return false;
        return true;
    }
    
    
    
    
    
    public List<List<Integer>> createAdj(int n , int[][]edge) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int e [] : edge) {
            int sv = e[0];
            int ev = e[1];
            
            adj.get(sv).add(ev);
            //adj.get(ev).add(sv);
        }
        return adj;
    }
}