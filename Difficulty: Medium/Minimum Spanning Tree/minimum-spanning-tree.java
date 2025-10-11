class Solution {
    public int spanningTree(int V, int[][] edges) {
        List<List<int[]>> adj = create(V , edges);
        
        int sum = 0;
        boolean [] inMst = new boolean [V];
        int [] par = new int [V];
        Arrays.fill(par , -1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.wt));
        pq.offer(new Pair(0,-1,0));
        
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int currNode = pair.node;
            int currPar = pair.par;
            int currWt = pair.wt;
            
            if(inMst[currNode]) continue;
            
            inMst[currNode] = true;
            par[currNode] = currPar;
            
            sum += currWt;
            
            List<int[]> neighList = adj.get(currNode);
            
            for(int [] neigh : neighList) {
                int neighNode = neigh[0];
                int neighWt = neigh[1];
                
                if(!inMst[neighNode]) {
                    pq.add(new Pair (neighNode , currNode , neighWt));
                }
            }
        }
        return sum;
        
    }
    
    public List<List<int[]>> create(int V , int [][] edges) {
        List<List<int[]>> adj =  new ArrayList<>();
        for(int i=0 ; i<V ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int [] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            
            adj.get(u).add(new int [] {v,wt});
            adj.get(v).add(new int [] {u,wt});
        }
        return adj;
    }
}

class Pair{
    int node;
    int par;
    int wt;
    
    Pair(int node , int par , int wt) {
        this.node = node;
        this.par = par;
        this.wt = wt;
    }
}