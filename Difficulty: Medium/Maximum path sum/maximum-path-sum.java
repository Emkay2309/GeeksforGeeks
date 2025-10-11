/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    int ans;
    int findMaxSum(Node root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    int dfs(Node root) {
        if (root == null) return 0;

        // Recursively find max path sum from left & right subtrees
        int l = Math.max(0, dfs(root.left));   // ignore negative paths
        int r = Math.max(0, dfs(root.right));

        // Max path that passes through this node
        int sum = l + r + root.data;

        // Update global max
        ans = Math.max(ans, sum);

        // Return max gain from this node to parent
        return Math.max(l, r) + root.data;
    }
}
