class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        if (start == end) return 0;

        // Queue for BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        // Visited array to avoid cycles
        boolean[] visited = new boolean[1000];
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int value = curr[0];
            int steps = curr[1];

            for (int num : arr) {
                int next = (value * num) % 1000;
                if (!visited[next]) {
                    if (next == end) return steps + 1;
                    visited[next] = true;
                    q.add(new int[]{next, steps + 1});
                }
            }
        }
        return -1; // Not reachable
    }
}