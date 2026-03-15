/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    static class Pair {
        int data, depth;
        Pair(int d, int dep) {
            data = d;
            depth = dep;
        }
    }

    Map<Integer, Pair> map;
    ArrayList<Integer> ans;

    public ArrayList<Integer> topView(Node root) {
        ans = new ArrayList<>();
        map = new TreeMap<>();

        dfs(root, 0, 0);

        for (Pair p : map.values()) {
            ans.add(p.data);
        }
        return ans;
    }

    // hd = horizontal distance, depth = level from root
    public void dfs(Node root, int hd, int depth) {
        if (root == null) return;

        if (!map.containsKey(hd) || map.get(hd).depth > depth) {
            map.put(hd, new Pair(root.data, depth));
        }

        dfs(root.left, hd - 1, depth + 1);
        dfs(root.right, hd + 1, depth + 1);
    }
}
