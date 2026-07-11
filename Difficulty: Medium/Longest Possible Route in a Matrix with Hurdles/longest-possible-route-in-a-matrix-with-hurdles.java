class Solution {
    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        int n = mat.length, m = mat[0].length;
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) return -1;
        boolean[][] visited = new boolean[n][m];
        int[] ans = {-1};
        dfs(mat, xs, ys, xd, yd, visited, 0, ans);
        return ans[0];
    }

    private void dfs(int[][] mat, int r, int c, int xd, int yd,
                     boolean[][] visited, int dist, int[] ans) {

        if (r == xd && c == yd) {
            ans[0] = Math.max(ans[0], dist);
            return;
        }

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + DR[i];
            int nc = c + DC[i];

            if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length &&
                mat[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(mat, nr, nc, xd, yd, visited, dist + 1, ans);
            }
        }

        visited[r][c] = false;
    }
}