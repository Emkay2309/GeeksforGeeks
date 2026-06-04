class Solution {
    int maxSubstring(String s) {
        int maxDiff = -1;
        int currentSum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Add contribution of current character
            if (s.charAt(i) == '0') {
                currentSum += 1;
            } else {
                currentSum -= 1;
            }
            
            // Update maximum
            if (currentSum > maxDiff) {
                maxDiff = currentSum;
            }
            
            // Reset if sum becomes negative (start new substring)
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        // If all ones, maxDiff will be -1, which is correct
        // If we found a positive sum, it will be returned
        return maxDiff;
    }
}