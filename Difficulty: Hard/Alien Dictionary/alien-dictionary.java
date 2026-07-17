class Solution {
    public String findOrder(String[] words) {

        ArrayList<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[26];
        boolean[] exists = new boolean[26];

        // Mark all existing characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            // Invalid case
            if (w1.length() > w2.length() && w1.startsWith(w2))
                return "";

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    int u = c1 - 'a';
                    int v = c2 - 'a';

                    // Avoid duplicate edge
                    if (!graph[u].contains(v)) {
                        graph[u].add(v);
                        indegree[v]++;
                    }

                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int i = 0; i < 26; i++) {
            if (exists[i] && indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {

            int curr = q.poll();
            ans.append((char) (curr + 'a'));

            for (int next : graph[curr]) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // Count total existing characters
        int totalChars = 0;
        for (boolean b : exists) {
            if (b)
                totalChars++;
        }

        // Cycle detected
        if (ans.length() != totalChars)
            return "";

        return ans.toString();
    }
}