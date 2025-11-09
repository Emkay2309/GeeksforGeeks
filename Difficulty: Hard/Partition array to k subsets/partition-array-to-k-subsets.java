/*You are required to complete this method */
class Solution {
    public boolean isKPartitionPossible(int[] arr, int k) {
        // Your code here
        int n = arr.length;
        int totalSum = 0;
        
        for (int i : arr) {
            totalSum += i;
        }
        
        if (totalSum % k != 0) {
            return false;
        }
   
        int targetSum = totalSum / k;
        
        boolean[] visited = new boolean[n];
        
        return canPartition(arr, visited, k, 0, targetSum, 0, n);
    }
    
    public boolean canPartition(int[] arr, boolean[] visited, int k, int currentSum, int targetSum, int startIndex, int n) {
   
        if (k == 1) {
            return true;
        }
        
        if (currentSum == targetSum) {
            return canPartition(arr, visited, k - 1, 0, targetSum, 0, n); 
        }
        
        for (int i = startIndex; i < n; i++) {
            if (!visited[i] && currentSum + arr[i] <= targetSum) {
            
                visited[i] = true;
                
           
                if (canPartition(arr, visited, k, currentSum + arr[i], targetSum, i + 1, n)) {
                    return true;
                }
                
                
                visited[i] = false;
            }
        }
        
        return false; 
    }
}