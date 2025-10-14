/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int ans;
    public int nodeSum(Node root, int l, int r) {
        // code here
        ans = 0;
        dfs(root , l , r);
        return ans;
    }
    
    public void dfs(Node root , int l , int r) {
        if(root == null) return;
        
        if(root.data >= l && root.data <= r) {
            ans += root.data;
        }
        
        dfs(root.left , l , r);
        dfs(root.right , l , r);
    }
}
