
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        ans = new ArrayList<>();
        for(int i=0; i<V ; i++) {
            ans.add(new ArrayList<>());
        }
        
        for(int [] a : edges) {
            int u = a[0];
            int v = a[1];
            
            ans.get(u).add(v);
            ans.get(v).add(u);
        }
        return ans;
    }
}