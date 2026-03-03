class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int count0 = 0;
        int n = arr.length;
        int index = 0;
        
        for(int i=0 ; i<n ; i++)  {
            if(arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
            else {
                count0++;
            }
        }
        
        int start = n-count0;
        
        for(int i=start ; i<n ; i++) {
            arr[i] = 0;
        }
    }
}