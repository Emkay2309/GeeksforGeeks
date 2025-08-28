class Solution {
    public int maxOnes(int arr[], int k) {
        int n = arr.length;
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLen = 0;

        while (right < n) {
            // expand window
            if (arr[right] == 0) {
                zeroCount++;
            }
            // shrink window if more than k zeros
            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
