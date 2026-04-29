class Solution {
    public int minSwaps(int[] arr) {
        // code here
        int n = arr.length;
        int one = 0;
        for(int i=0;i<n;i++){
            one += arr[i];
        }
        if(one==0) return -1;

        int sum = 0;
        for(int i=0;i<one;i++){
            sum += arr[i];
        }

        int ans = one - sum;
        for(int i=one;i<n;i++){
            sum = sum - arr[i-one] + arr[i];
            int temp = one - sum;
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}