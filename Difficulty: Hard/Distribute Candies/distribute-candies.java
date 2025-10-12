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
    int ans;
    public int distCandy(Node root) {
        // code here
         // code here
        ans = 0;
        if(root == null) return ans;
        dfs(root);
        return ans;
    }
    
    public  int dfs(Node root) {
        if(root == null) return 0;
        
        int left  = dfs(root.left);
        int right = dfs(root.right);
        
        ans += Math.abs(left) + Math.abs(right);
        
        return (left+right+root.data)-1;
    }
}