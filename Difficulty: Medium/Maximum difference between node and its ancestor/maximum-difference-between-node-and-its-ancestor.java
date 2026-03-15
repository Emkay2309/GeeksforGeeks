/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int max_diff = Integer.MIN_VALUE;
    
    int maxDiff(Node root) {
        if(root == null) return 0;
        helper(root);
        return max_diff;
    }
    
    int helper(Node node) {
        if(node == null) return Integer.MAX_VALUE;
        
        if(node.left == null && node.right == null) {
            return node.data;
        }
        
        int leftMin = helper(node.left);
        int rightMin = helper(node.right);
        int subtreeMin = Math.min(leftMin, rightMin);
        
        max_diff = Math.max(max_diff, node.data - subtreeMin);
        
        return Math.min(subtreeMin, node.data);
    }
}
