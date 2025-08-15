class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        boolean [][] vis = new boolean[n][m];

        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image; 

        dfs(sr, sc, n, m, newColor, originalColor, vis, image);
        return image;
    }
    
    public void dfs(int r, int c, int n, int m, int newColor, int originalColor, boolean [][]vis, int [][]image) {
        if (r < 0 || c < 0 || r >= n || c >= m || vis[r][c] || image[r][c] != originalColor) 
            return;
        
        vis[r][c] = true;
        image[r][c] = newColor;
        
        dfs(r+1, c, n, m, newColor, originalColor, vis, image);
        dfs(r-1, c, n, m, newColor, originalColor, vis, image);
        dfs(r, c+1, n, m, newColor, originalColor, vis, image);
        dfs(r, c-1, n, m, newColor, originalColor, vis, image);
    }
}
