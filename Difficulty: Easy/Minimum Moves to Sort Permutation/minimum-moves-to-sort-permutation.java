class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // pos[v] = index of value v (values are 1..n)
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int maxLen = 1;
        int currentLen = 1;

        for (int v = 2; v <= n; v++) {
            if (pos[v] > pos[v - 1]) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }

        return n - maxLen;
    }
}