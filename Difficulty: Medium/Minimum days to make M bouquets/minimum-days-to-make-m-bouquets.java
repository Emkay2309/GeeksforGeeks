class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        long val=(long) m * k;
        if((val) > arr.length){
            return -1;
        } 
        int ans = -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        for(int i=0; i<arr.length; i++) {
            low = Math.min(low ,arr[i]); //2
            high = Math.max(high ,arr[i]); //13
        }
    
        while(low <= high){
            int  mid = low + (high-low) / 2 ;  // 7
            if(isPossible(arr, m, k, mid))  {
                ans =  mid;
                high = mid-1;
            }
            else    {
                low = mid+1;
            }
        }
        return ans;
    }
    
    static boolean isPossible(int arr[], int flower, int days, int mid) {
        int count = 0;
        int countB = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= mid){
                count++;
            }
            else  {
                count = count - (count % days);
            }
        }
        
        count = count / days;
        return count >= flower;
    }
    
}