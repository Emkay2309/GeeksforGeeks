/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        int ans = -1;
        
        while(root != null) {
            int curr = root.data;
            
            if(curr == k) return k;
            
            if(curr < k) {
                ans = curr;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return ans;
    }
}