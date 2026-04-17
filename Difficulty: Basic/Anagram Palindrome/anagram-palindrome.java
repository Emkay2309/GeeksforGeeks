class Solution {
    boolean canFormPalindrome(String s) {
        // Count frequency of each character
        int[] freq = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            freq[curr]++;
        }
        
        // Count how many characters have odd frequency
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
            }
        }
        
        // A string can form a palindrome if:
        // For even length string: oddCount must be 0
        // For odd length string: oddCount must be 1
        if (s.length() % 2 == 0) {
            return oddCount == 0;
        } else {
            return oddCount == 1;
        }
    }
}