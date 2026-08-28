class Solution {
    static boolean isCircle(String[] arr) {
        int[] in = new int[26];
        int[] out = new int[26];
        boolean[][] graph = new boolean[26][26];

        // Build graph
        for (String s : arr) {
            int first = s.charAt(0) - 'a';
            int last = s.charAt(s.length() - 1) - 'a';

            out[first]++;
            in[last]++;

            graph[first][last] = true;
            graph[last][first] = true;
        }

        // Check in-degree == out-degree
        for (int i = 0; i < 26; i++) {
            if (in[i] != out[i]) {
                return false;
            }
        }

        // Find starting character
        int start = arr[0].charAt(0) - 'a';

        // Check connectivity
        boolean[] visited = new boolean[26];
        dfs(start, graph, visited);

        // Every character used in strings should be connected
        for (int i = 0; i < 26; i++) {
            if ((in[i] > 0 || out[i] > 0) && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    static void dfs(int node, boolean[][] graph, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < 26; i++) {
            if (graph[node][i] && !visited[i]) {
                dfs(i, graph, visited);
            }
        }
    }
}