// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int [] ans = new int [V];
        Arrays.fill(ans , (int)Math.pow(10,8));
        ans[src] = 0;
        
        for(int i=1 ; i<=V-1 ; i++) {
            for(int [] e : edges) {
                int u = e[0];
                int v = e[1];
                int wt = e[2];
                
                if(ans[u] != (int)Math.pow(10,8) && ans[u]+wt < ans[v]) {
                    ans[v] = ans[u]+wt;
                }
            }
        }
        
        //detect -ve cycle
        for(int [] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            if(ans[u] != (int)Math.pow(10,8) && ans[u]+wt < ans[v]) {
                return new int []{-1};
            }
        }
        
        return ans;
    }
}
