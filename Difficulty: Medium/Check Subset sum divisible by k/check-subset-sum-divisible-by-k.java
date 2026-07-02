class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        // Using HashSet to track possible remainders
        Set<Integer> remainders = new HashSet<>();
        remainders.add(0); // Empty subset
        
        for (int num : arr) {
            Set<Integer> newRemainders = new HashSet<>(remainders);
            int mod = ((num % k) + k) % k;
            
            for (int rem : remainders) {
                int newRem = (rem + mod) % k;
                if (newRem == 0) {
                    // Found a non-empty subset
                    return true;
                }
                newRemainders.add(newRem);
            }
            
            remainders = newRemainders;
        }
        
        return false;
    }
}