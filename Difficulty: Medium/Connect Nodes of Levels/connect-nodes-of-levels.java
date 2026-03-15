/*
   class Node{
       int data;
       Node left;
       Node right;
       Node nextRight;
       Node(int data){
           this.data = data;
           left=null;
           right=null;
           nextRight = null;
       }
   }

   */

class Solution {
    public Node connect(Node root) {
        // code here.
        Queue<Node> queue=new LinkedList<>();
        
        queue.add(root);
        queue.add(null);
        
        root.nextRight=null;
        
        while(queue.size()>1){
            Node node=queue.remove();
            if(node==null)
            {
                queue.add(null);
                continue;
            }
            node.nextRight=queue.peek();
            
            if(node.left!=null)queue.add(node.left);
            if(node.right!=null)queue.add(node.right);
            
        }
        return root;
    }
}