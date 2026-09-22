class Solution {
    public boolean areAnagrams(Node root1, Node root2) {

        Map<Integer, Map<Integer, Integer>> map1 = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> map2 = new HashMap<>();

        dfs(root1, 0, map1);
        dfs(root2, 0, map2);

        return map1.equals(map2);
    }

    void dfs(Node root, int level,
             Map<Integer, Map<Integer, Integer>> map) {

        if (root == null)
            return;

        map.putIfAbsent(level, new HashMap<>());

        Map<Integer, Integer> freq = map.get(level);

        freq.put(root.data, freq.getOrDefault(root.data, 0) + 1);

        dfs(root.left, level + 1, map);
        dfs(root.right, level + 1, map);
    }
}