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
    
    int maxTime = 0;
    
    public int minTime(Node root, int target) {
        solve(root, target);
        return maxTime;
    }
    
    // returns distance of current node from target
    int solve(Node root, int target) {
        if (root == null) return -1;
        
        // target found
        if (root.data == target) {
            burnDown(root, 0);
            return 1;
        }
        
        int left = solve(root.left, target);
        int right = solve(root.right, target);
        
        // target found in left subtree
        if (left != -1) {
            maxTime = Math.max(maxTime, left);
            burnDown(root.right, left + 1);
            return left + 1;
        }
        
        // target found in right subtree
        if (right != -1) {
            maxTime = Math.max(maxTime, right);
            burnDown(root.left, right + 1);
            return right + 1;
        }
        
        return -1;
    }
    
    // burn subtree downward
    void burnDown(Node root, int time) {
        if (root == null) return;
        
        maxTime = Math.max(maxTime, time);
        
        burnDown(root.left, time + 1);
        burnDown(root.right, time + 1);
    }
}