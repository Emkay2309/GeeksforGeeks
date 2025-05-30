/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    
    private int maxLen;
    private int maxSum;
    
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        maxLen = 0;
        maxSum = 0;
        dfs(root , 0 , 0);
        return maxSum;
    }
    
    public void dfs(Node root , int currLen , int currSum) {
        if(root == null) return;
        
        currLen += 1;
        currSum += root.data;
        
        //if it is a leaf node 
        //then calculate sum and len and update global len and sum
        if(root.left == null && root.right == null) {
            //if the currlen is more than global answers , then update len and sum global
            if(currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            }
            // if at any point you see the lens are equal then , maximize the global answer
            else if(currLen == maxLen) {
                maxSum = Math.max(currSum , maxSum);
            }
        }
        
        
        dfs(root.left , currLen , currSum);
        dfs(root.right , currLen , currSum);
    }
}