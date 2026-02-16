class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
         // Sort meetings based on start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Check for overlap
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < arr[i - 1][1]) {
                return false;
            }
        }
        
        return true;
    }
}