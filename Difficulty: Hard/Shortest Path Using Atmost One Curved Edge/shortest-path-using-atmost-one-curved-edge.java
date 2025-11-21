class Solution {
    static class Edge {
        final int to;
        final int w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    public int shortestPath(int V, int a, int b, int[][] edges) {
        if (V <= 0) return -1;

        // Use List<List<Edge>> instead of List<Edge>[] to avoid generic-array warnings
        List<List<Edge>> adj = new ArrayList<>(V * 2);
        for (int i = 0; i < V * 2; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int x = e[0], y = e[1], w1 = e[2], w2 = e[3];
            int x0 = x, x1 = x + V, y0 = y, y1 = y + V;

            // straight edges on both layers
            adj.get(x0).add(new Edge(y0, w1));
            adj.get(y0).add(new Edge(x0, w1));
            adj.get(x1).add(new Edge(y1, w1));
            adj.get(y1).add(new Edge(x1, w1));

            // curved edges: only from layer0 -> other layer1
            adj.get(x0).add(new Edge(y1, w2));
            adj.get(y0).add(new Edge(x1, w2));
        }

        final long INF = Long.MAX_VALUE / 4;
        int N = V * 2;
        long[] dist = new long[N];
        Arrays.fill(dist, INF);
        boolean[] seen = new boolean[N];

        // priority queue of {dist, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a2 -> a2[0]));
        dist[a] = 0;
        pq.add(new long[]{0L, a});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (seen[u]) continue;
            seen[u] = true;

            for (Edge ed : adj.get(u)) {
                int v = ed.to;
                long nd = d + ed.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new long[]{nd, v});
                }
            }
        }

        long ans = Math.min(dist[b], dist[b + V]);
        return ans >= INF ? -1 : (int) ans;
    }
}