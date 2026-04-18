class Solution {
    int maxOnes(int[] arr) {
        int totalOnes = 0;
        
        for (int num : arr) {
            totalOnes += num;
        }

        int maxGain = 0;
        int currentGain = 0;

        for (int num : arr) {
            // Transform: 0 -> +1, 1 -> -1
            int value = (num == 0) ? 1 : -1;

            currentGain = Math.max(value, currentGain + value);
            maxGain = Math.max(maxGain, currentGain);
        }

        return totalOnes + maxGain;
    }
}