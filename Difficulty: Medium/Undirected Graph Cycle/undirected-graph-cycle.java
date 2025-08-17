class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = createAdj(V , edges);
        boolean [] vis = new boolean [V];
        
        for(int i=0 ; i<V ; i++) {
            if(!vis[i]) {
                //boolean check = dfs(i , -1, vis , adj);
                boolean check1 = bfs( i , vis , adj);
                if(check1) return true;
                //if(check) return true;
            }
        }
        return false;
    }
    
    public boolean bfs(int curr , boolean [] vis , List<List<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(curr , -1));
        vis[curr] = true;
        
        while(!q.isEmpty()) {
            Pair currPair = q.poll();
            
            int node = currPair.node;
            int par = currPair.par;
            
            for(int neigh : adj.get(node)) {
                if(!vis[neigh]) {
                    q.add(new Pair(neigh , node));
                    vis[neigh] = true;
                }
                else if(neigh != par) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int curr , int par , boolean [] vis , List<List<Integer>> adj ) {
        vis[curr] = true;
        
        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                if(dfs(neigh , curr , vis , adj) )   return true;
            }
            else if (par != neigh) {
                return true;
            }
        }
        return false;
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
            adj.get(ev).add(sv);
        }
        return adj;
    }
}

class Pair {
    int node;
    int par;
    
    Pair(int node , int par) {
        this.node = node;
        this.par = par;
    }
}