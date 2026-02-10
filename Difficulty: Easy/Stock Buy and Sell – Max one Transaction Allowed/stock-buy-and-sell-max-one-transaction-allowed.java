class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int start = 0;
        int end = 1;
        int maxProfit = 0;

        while (end < prices.length) {
            while (end < prices.length && prices[start] < prices[end]){
                maxProfit = Math.max(maxProfit, prices[end] - prices[start]);
                end++;
            }
            start = end;
            end = start + 1;
        }
        return maxProfit;
    }
}