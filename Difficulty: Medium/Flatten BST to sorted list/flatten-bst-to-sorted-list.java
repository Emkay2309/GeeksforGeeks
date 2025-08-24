// User function Template for Java
class Solution {
    
    public Node prev = null;
    
    public Node flattenBST(Node root) {
        // Code here
        if(root == null) return null;
        Node dummy = new Node(-1);
        prev = dummy;
        
        dfs(root);
        return dummy.right;
    }
    
    public void dfs(Node root) {
        if(root == null) return;
        
        dfs(root.left);
        
        root.left = null;
        prev.right = root;
        prev = root;
        
        dfs(root.right);
    }
}
