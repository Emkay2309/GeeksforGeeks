class Solution {
    public Node flatten(Node root) {
        if (root == null || root.next == null) return root;
        
        Node flattenedNext = flatten(root.next);
        return merge(root, flattenedNext);
    }
    
    public Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        
        Node result;
        
        if (a.data <= b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        
        // Clear the next pointer for merged result
        result.next = null;
        
        return result;
    }
}