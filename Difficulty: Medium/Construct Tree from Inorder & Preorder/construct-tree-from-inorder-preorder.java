/*
Definition for Node
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
    static int idx;
    public static Node buildTree(int inorder[], int preorder[]) {
        idx = 0;
        int n = inorder.length;
        return dfs(0,n-1,inorder,preorder);
    }
    
    public static Node dfs(int start , int end , int [] in , int [] pre) {
        if(start > end) return null;
        
        int rootVal = pre[idx];
        int i=start;
        
        for(; i<=end ; i++) {
            if(rootVal == in[i]) break;
        }
        
        idx++;
        Node root = new Node(rootVal);
        root.left = dfs(start , i-1 , in , pre);
        root.right = dfs(i+1 , end , in , pre);
        
        return root;
    }
}