// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    static int maxSize = 0;
    
    static int[] helper(Node root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        if (left[1] < root.data && root.data < right[0]) {
            int size = left[2] + right[2] + 1;
            maxSize = Math.max(maxSize, size);
            int minVal = Math.min(left[0], root.data);
            int maxVal = Math.max(right[1], root.data);
            return new int[]{minVal, maxVal, size};
        }
        
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        maxSize = 0;
        helper(root);
        return maxSize;
    }
}
