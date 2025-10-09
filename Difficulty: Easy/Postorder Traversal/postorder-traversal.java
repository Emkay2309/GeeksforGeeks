/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> ans;
    public ArrayList<Integer> postOrder(Node root) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        
        dfs(root);
        return ans;
    }
    
    public void dfs(Node root) {
        if(root == null) return;
        
        dfs(root.left);
        dfs(root.right);
        ans.add(root.data);
    }
}