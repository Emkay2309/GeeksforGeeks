class Solution {
    public void sort012(int[] arr) {
        // code here
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid] and move both pointers
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // Move to the next element
                mid++;
            } else if (arr[mid] == 2) {
                // Swap arr[mid] and arr[high] and move high pointer
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}