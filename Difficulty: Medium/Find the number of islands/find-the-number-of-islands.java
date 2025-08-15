class Solution {
    public int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L' && !vis[i][j]) {
                    dfs(i, j, n, m, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, int n, int m, boolean[][] vis, char[][] grid) {
        if (row < 0 || col < 0 || row >= n || col >= m || vis[row][col] || grid[row][col] == 'W') 
            return;

        vis[row][col] = true;

        dfs(row + 1, col, n, m, vis, grid);
        dfs(row - 1, col, n, m, vis, grid);
        dfs(row, col + 1, n, m, vis, grid);
        dfs(row, col - 1, n, m, vis, grid);
        
        dfs(row + 1, col+1, n, m, vis, grid);
        dfs(row - 1, col-1, n, m, vis, grid);
        dfs(row-1, col + 1, n, m, vis, grid);
        dfs(row+1, col - 1, n, m, vis, grid);
    }
}
