class Solution {
    public int maxSumSubarray(int[] arr) {
        // code here
        int res = arr[0];
        int currSum = arr[0];
        int oneDelete = arr[0];
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            
            // oneDelete can skip atmost one number
            oneDelete = Math.max(currSum, oneDelete + curr);
            
            // currSum will contains a continious subarray sum
            currSum = Math.max(currSum + curr, curr);
            
            res = Math.max(res, Math.max(currSum, oneDelete));
        }
        return res;
    }
}