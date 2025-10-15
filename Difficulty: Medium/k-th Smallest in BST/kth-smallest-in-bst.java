class Solution {
    int count;
    public int kthSmallest(Node root, int k) {
        if(root == null) return -1;
        count = k;
        
        Node result = dfs(root);
        return (result != null) ? result.data : -1;
    }
    
    public Node dfs(Node root) {
        if(root == null) return null;
        
        // Traverse left subtree
        Node left = dfs(root.left);
        if(left != null) return left;
        
        // Process current node
        count--;
        if(count == 0) return root;
        
        // Traverse right subtree
        return dfs(root.right);
    }
}