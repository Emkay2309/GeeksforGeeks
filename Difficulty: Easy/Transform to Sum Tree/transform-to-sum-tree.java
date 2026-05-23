/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution {
    
    public void toSumTree(Node root) {
        dfs(root);
    }
    
    public int dfs(Node root) {
        if (root == null) return 0;

        // Store original value
        int oldValue = root.data;

        // Recursively get left and right subtree sums
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        // Update current node with sum of left + right subtree
        root.data = leftSum + rightSum;

        // Return total sum including original node value
        return root.data + oldValue;
    }
}