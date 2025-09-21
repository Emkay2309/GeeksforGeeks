import java.util.*;
public class Solution {
    public int maxArea(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int n = mat.length;
        int m = mat[0].length;
        int maxArea = 0;
        int[] heights = new int[m]; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] extended = new int[len + 1];
        System.arraycopy(heights, 0, extended, 0, len);
        extended[len] = 0;

        Deque<Integer> stack = new ArrayDeque<>(); 
        int maxArea = 0;

        for (int i = 0; i < extended.length; i++) {
            while (!stack.isEmpty() && extended[stack.peekLast()] > extended[i]) {
                int height = extended[stack.pollLast()];
                int width = stack.isEmpty() ? i : i - stack.peekLast() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.addLast(i);
        }
        return maxArea;
    }
}