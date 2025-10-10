/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<ArrayList<Integer>> levels;
    ArrayList<Integer> ans;

    ArrayList<Integer> zigZagTraversal(Node root) {
        ans = new ArrayList<>();
        levels = new ArrayList<>();
        dfs(root, 0);

        // Flatten all levels into ans
        for (ArrayList<Integer> lvl : levels) ans.addAll(lvl);

        return ans;
    }

    public void dfs(Node root, int level) {
        if (root == null) return;

        // If first time visiting this level
        if (levels.size() == level)
            levels.add(new ArrayList<>());

        // Even → left to right, Odd → right to left
        if (level % 2 == 0)
            levels.get(level).add(root.data);
        else
            levels.get(level).add(0, root.data);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
