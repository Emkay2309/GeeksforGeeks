class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        int [] in = new int [V];
        
        for(int [] e : edges) {
            int u = e[0];
            int v = e[1];
            in[v]++;
        }
        
        int sum = 0;
        for(int n : in) {
            sum += n;
        }
        
        int total = V*(V-1)/2;
        return total-sum;
    }
}