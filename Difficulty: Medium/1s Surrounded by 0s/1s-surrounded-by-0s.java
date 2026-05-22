class Solution {
    int n, m;
    int[][] vis;

    void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        if (grid[i][j] == 0 || vis[i][j] == 1) return;

        vis[i][j] = 1;
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }

    int cntOnes(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new int[n][m];

        // Step 1: Mark all boundary-connected 1s
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][m - 1] == 1) dfs(i, m - 1, grid);
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid);
            if (grid[n - 1][j] == 1) dfs(n - 1, j, grid);
        }

        // Step 2: Count unvisited 1s (trapped ones)
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    trapped++;
                }
            }
        }
        return trapped;
    }
};