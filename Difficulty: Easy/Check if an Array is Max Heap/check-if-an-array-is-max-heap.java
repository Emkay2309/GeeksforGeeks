class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        
        // Check heap property for all parent nodes
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // Left child index
            int left = 2 * i + 1;
            if (left < n && arr[i] < arr[left]) {
                return false;
            }
            // Right child index
            int right = 2 * i + 2;
            if (right < n && arr[i] < arr[right]) {
                return false;
            }
        }
        return true;
    }
}