class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        dfs(1 , n , k , new ArrayList<>() , ans);
        return ans;
    }
    
    public void dfs(int start , int target , int k , ArrayList<Integer> curr , ArrayList<ArrayList<Integer>> ans) {
        if(target == 0  &&  curr.size() == k) {
            ans.add( new ArrayList<>(curr));
            return;
        }
        
        if(target < 0  ||  curr.size() > k) {
            return;
        }
        
        
        for(int i=start ; i<=9 ; i++) {
            curr.add(i);
            dfs(i+1 , target-i , k , curr , ans);
            curr.remove(curr.size()-1);
        }
    }
}