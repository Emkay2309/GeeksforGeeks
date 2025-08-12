class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices); // Step 1: sort ascending

        // Minimum cost
        int minCost = 0;
        int start = 0;       // buy from the cheapest
        int end = prices.length - 1;
        while (start <= end) {
            minCost += prices[start]; // buy cheapest
            start++;                  // move to next cheapest
            end -= k;                 // take k expensive candies for free
        }

        // Maximum cost
        int maxCost = 0;
        start = 0;
        end = prices.length - 1; // buy from the most expensive
        while (start <= end) {
            maxCost += prices[end]; // buy most expensive
            end--;                  // move to next expensive
            start += k;             // take k cheap candies for free
        }
        
        return new ArrayList<>(Arrays.asList(minCost,maxCost));
    }
}