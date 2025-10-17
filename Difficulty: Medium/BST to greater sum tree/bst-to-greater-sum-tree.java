/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    static int sum;
    public static void transformTree(Node root) {
        sum = 0;
        dfs(root);
    }
    
    public static void dfs(Node root) {
        if(root == null) return;
        
        dfs(root.right);
        
        int currVal = root.data;
        root.data = sum;
        sum += currVal;
        
        dfs(root.left);
    }
}