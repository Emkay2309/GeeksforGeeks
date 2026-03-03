class Solution {
    public int totalElements(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int maxLength = 0;
        int left = 0;
        
        // Variables to track two distinct numbers and their counts
        int first = -1, second = -1;
        int firstCount = 0, secondCount = 0;
        
        for (int right = 0; right < arr.length; right++) {
            int current = arr[right];
            
            // If current matches either of our two numbers
            if (first == current) {
                firstCount++;
            } else if (second == current) {
                secondCount++;
            } 
            // If we have room for a new distinct number
            else if (first == -1) {
                first = current;
                firstCount++;
            } else if (second == -1) {
                second = current;
                secondCount++;
            } 
            // Need to remove one of the existing numbers
            else {
                // Move left pointer and decrement counts
                while (left < right && first != -1 && second != -1) {
                    int leftElement = arr[left];
                    
                    if (leftElement == first) {
                        firstCount--;
                        if (firstCount == 0) first = -1;
                    } else if (leftElement == second) {
                        secondCount--;
                        if (secondCount == 0) second = -1;
                    }
                    
                    left++;
                    
                    // If we've removed one distinct number, break
                    if (first == -1 || second == -1) {
                        break;
                    }
                }
                
                // Add the new number
                if (first == -1) {
                    first = current;
                    firstCount++;
                } else {
                    second = current;
                    secondCount++;
                }
            }
            
            // Update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}