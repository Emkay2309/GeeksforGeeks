/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    // Helper class to return pair of values
    static class Pair {
        int include;  // sum including current node
        int exclude;  // sum excluding current node
        
        Pair(int include, int exclude) {
            this.include = include;
            this.exclude = exclude;
        }
    }
    
    private Pair fun(Node root) {
        if(root == null)
            return new Pair(0, 0);
            
        Pair l = fun(root.left);
        Pair r = fun(root.right);
        
        int include = root.data + l.exclude + r.exclude;
        int exclude = Math.max(l.include, l.exclude) + Math.max(r.include, r.exclude);
        
        return new Pair(include, exclude);
    }
    
    public int getMaxSum(Node root) {
        Pair res = fun(root);
        return Math.max(res.include, res.exclude);
    }
}