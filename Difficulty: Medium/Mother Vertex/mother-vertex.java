class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        // Step 2: Do DFS to find candidate mother vertex
        boolean[] visited = new boolean[V];
        int candidate = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                candidate = i; // last finished vertex
            }
        }

        // Step 3: Verify candidate by running DFS again
        Arrays.fill(visited, false);
        dfs(candidate, adj, visited);

        for (boolean v : visited) {
            if (!v) return -1; // not all reachable
        }

        return candidate;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei, adj, visited);
            }
        }
    }
}