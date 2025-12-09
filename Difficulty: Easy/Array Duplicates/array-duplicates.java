class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList <Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int idx = Math.abs(arr[i]) - 1;
            
            if(arr[idx] > 0){
                arr[idx] = -arr[idx];
            }
            else {
                ans.add(Math.abs(arr[i]));
            }
        }
        return ans;
    }
}