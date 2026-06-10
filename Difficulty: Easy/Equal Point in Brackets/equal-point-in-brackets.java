class Solution {
    public int findIndex(String s) {
        // code here
        int n = s.length();

        int closeRemaining = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                closeRemaining++;
            }
        }

        int openCount = 0;

        for (int i = 0; i < n; i++) {
            if (openCount == closeRemaining) {
                return i;
            }

            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                closeRemaining--;
            }
        }

        // Check split position at n
        if (openCount == closeRemaining) {
            return n;
        }

        return n;
    }
}