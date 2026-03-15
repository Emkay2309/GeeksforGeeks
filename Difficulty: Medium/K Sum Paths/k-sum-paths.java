/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int countAllPaths(Node root, int k) {
        if (root == null) return 0;
        
        // Count paths starting from current node + paths in left/right subtrees
        return countPathsFromNode(root, k, 0) + 
               countAllPaths(root.left, k) + 
               countAllPaths(root.right, k);
    }
    
    private int countPathsFromNode(Node node, int k, long currentSum) {
        if (node == null) return 0;
        
        currentSum += node.data;
        int count = 0;
        
        if (currentSum == k) count++;
        
        count += countPathsFromNode(node.left, k, currentSum);
        count += countPathsFromNode(node.right, k, currentSum);
        
        return count;
    }
}