class Solution {
    Map<Integer, Pair> map;

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        map = new TreeMap<>();

        dfs(root, 0, 0);

        for (Pair p : map.values()) {
            ans.add(p.data);
        }

        return ans;
    }

    public void dfs(Node root, int hd, int level) {
        if (root == null)
            return;

        if (!map.containsKey(hd) || map.get(hd).depth > level) {
            map.put(hd, new Pair(root.data, level));
        }

        dfs(root.left, hd - 1, level + 1);
        dfs(root.right, hd + 1, level + 1);
    }
}

class Pair {
    int data;
    int depth;

    Pair(int data, int depth) {
        this.data = data;
        this.depth = depth;
    }
}