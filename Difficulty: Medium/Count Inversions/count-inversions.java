class Solution {
    static int inversionCount(int arr[]) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }
    
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Count inversions in left half
            count += mergeSortAndCount(arr, left, mid);
            
            // Count inversions in right half
            count += mergeSortAndCount(arr, mid + 1, right);
            
            // Count split inversions during merge
            count += mergeAndCount(arr, left, mid, right);
        }
        
        return count;
    }
    
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];
        
        // Copy data to temp arrays
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightArr.length; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        int count = 0;
        
        // Merge and count inversions
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                // arr[i] > arr[j] → all remaining elements in leftArr form inversions
                arr[k++] = rightArr[j++];
                count += (leftArr.length - i);
            }
        }
        
        // Copy remaining elements
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
        
        return count;
    }
}