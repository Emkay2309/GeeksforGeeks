class Solution {
    public int getCount(int n) {
        int count = 0;
        for (int k = 2; (long) k * (k + 1) / 2 <= n; k++) {
            long num = 2L * n - (long) k * (k - 1);
            if (num > 0 && num % (2L * k) == 0) {
                count++;
            }
        }
        return count;
    }
}