/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
     boolean isSumTree(Node root) {
        // Your code here
        if(root == null)
          return true ;
        if(root.left == null && root.right == null)
          return true ;
          
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int sum = leftSum + rightSum ;
        return (root.data == sum ) && isSumTree(root.left) && isSumTree(root.right);

    }
    
    int getSum(Node node) {
        
        
        if(node == null)
          return 0;
        if(node.left == null && node.right == null)
          return node.data ;
          
        return getSum(node.left) + getSum(node.right) + node.data;  
          
    }
}