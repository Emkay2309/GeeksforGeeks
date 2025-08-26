// User function Template for Java

class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        dfs(0 , new ArrayList<Integer>() , arr);
        // sort lexicographically
        Collections.sort(ans, (a, b) -> {
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return a.size() - b.size();
        });
        return ans;
    }
    
    public void dfs(int i , ArrayList<Integer> curr , int [] arr) {
        if(i == arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(arr[i]);
        dfs(i+1 , curr , arr);
        curr.remove(curr.size()-1);
        
        dfs(i+1 , curr , arr);
    }
}