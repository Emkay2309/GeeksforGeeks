class Solution {
    public int minCost(int[] heights, int[] cost) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int h : heights) {
            if (h < left) left = h;
            if (h > right) right = h;
        }
        
        while (left < right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            
            long cost1 = calculateCost(heights, cost, mid1);
            long cost2 = calculateCost(heights, cost, mid2);
            
            if (cost1 < cost2) {
                right = mid2 - 1;
            } else {
                left = mid1 + 1;
            }
        }
        
        return (int) calculateCost(heights, cost, left);
    }
    
    private long calculateCost(int[] heights, int[] cost, int target) {
        long totalCost = 0;
        for (int i = 0; i < heights.length; i++) {
            totalCost += (long) Math.abs(heights[i] - target) * cost[i];
        }
        return totalCost;
    }
}