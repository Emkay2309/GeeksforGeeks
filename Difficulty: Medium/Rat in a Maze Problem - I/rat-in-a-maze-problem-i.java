import java.util.*;

class Solution {
    // Return all paths in lexicographic order
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length, m = maze[0].length;
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0 || m == 0 || maze[0][0] == 0 || maze[n-1][m-1] == 0) return ans;

        boolean[][] vis = new boolean[n][m];
        StringBuilder path = new StringBuilder();

        // Try moves in D, L, R, U order (lexicographic by letters)
        char[] dir = {'D','L','R','U'};
        int[] di   = { 1,  0,  0, -1};
        int[] dj   = { 0, -1,  1,  0};

        dfs(0, 0, n, m, maze, vis, dir, di, dj, path, ans);

        // Ensure lexicographic order regardless of traversal
        Collections.sort(ans);
        return ans;
    }

    private void dfs(int i, int j, int n, int m, int[][] maze, boolean[][] vis,char[] dir, int[] di, int[] dj,StringBuilder path, ArrayList<String> ans) {

        if (i == n-1 && j == m-1) {
            ans.add(path.toString());
            return;
        }

        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int ni = i + di[k], nj = j + dj[k];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m &&
                maze[ni][nj] == 1 && !vis[ni][nj]) {

                path.append(dir[k]);
                dfs(ni, nj, n, m, maze, vis, dir, di, dj, path, ans);
                path.deleteCharAt(path.length() - 1); // backtrack
            }
        }

        vis[i][j] = false;
    }
}
