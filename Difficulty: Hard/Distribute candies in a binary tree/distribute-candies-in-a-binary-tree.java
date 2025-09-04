
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
}*/

class Solution {
    static int ans;
    public static int distributeCandy(Node root) {
        // code here
        ans = 0;
        if(root == null) return ans;
        dfs(root);
        return ans;
    }
    
    public static int dfs(Node root) {
        if(root == null) return 0;
        
        int left  = dfs(root.left);
        int right = dfs(root.right);
        
        ans += Math.abs(left) + Math.abs(right);
        
        return (left+right+root.data)-1;
    }
}