// User function template for JAVA

class Solution {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        // add your code here
        ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<Integer> curr = new ArrayList<>();
        
        dfs( 0 , 0 , curr , target , n , arr );
        return ans;
    }
    
    static void dfs(int i , int sum , ArrayList<Integer> curr , int k , int n , int [] arr)  {
        if (sum > k || i >= n) return;
  
        if (sum == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(arr[i]);
        dfs(i , sum+arr[i] , curr , k , n , arr);
        curr.remove(curr.size()-1);
        
        dfs(i+1 , sum , curr , k , n , arr);
    }
}