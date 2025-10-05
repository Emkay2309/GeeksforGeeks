import java.util.*;

class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        
        ArrayList<String> ans = new ArrayList<>();
        
        if (maze[0][0] == 0 || maze[n-1][m-1] == 0) return ans;
        
        dfs(0, 0, n, m, new StringBuilder(), ans, maze);
        Collections.sort(ans);
        return ans;
    }
    
    public void dfs(int i, int j, int n, int m, StringBuilder curr, ArrayList<String> ans, int[][] mat) {
        // invalid or blocked cell
        if (i < 0 || i >= n || j < 0 || j >= m || mat[i][j] == 0) return;
        
        // reached destination
        if (i == n-1 && j == m-1) {
            ans.add(curr.toString());
            return;
        }
        
        mat[i][j] = 0; // mark visited
        
        // Right
        curr.append("R");
        dfs(i, j+1, n, m, curr, ans, mat);
        curr.deleteCharAt(curr.length()-1);
        
        // Down
        curr.append("D");
        dfs(i+1, j, n, m, curr, ans, mat);
        curr.deleteCharAt(curr.length()-1);
        
        // Left
        curr.append("L");
        dfs(i, j-1, n, m, curr, ans, mat);
        curr.deleteCharAt(curr.length()-1);
        
        // Up
        curr.append("U");
        dfs(i-1, j, n, m, curr, ans, mat);
        curr.deleteCharAt(curr.length()-1);
        
        mat[i][j] = 1; // unmark for other paths
    }
}
