class Solution {
    public void sortIt(int[] arr) {
        // code here
        int i=0, j=0, k=0;
        int n = arr.length;

        while(j<n) {
            if(arr[j]%2 != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }

        Arrays.sort(arr, 0, i);
        Arrays.sort(arr, i, n);
        int l= i-1;
        
        while(k <= l) {
            int temp = arr[k];
            arr[k] = arr[l];
            arr[l] = temp;
            k++;
            l--;
        }
    }
}
