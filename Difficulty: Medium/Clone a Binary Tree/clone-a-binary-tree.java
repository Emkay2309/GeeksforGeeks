/*Complete the function below
Node is as follows:
class Tree{
    int data;
    Tree left,right,random;
    Tree(int d){
        data=d;
        left=null;
        right=null;
        random=null;
    }
}*/
class Solution {
    
    HashMap<Tree, Tree> hp = new HashMap<>();
    
    public Tree cloneTree(Tree root) {
        if(root==null) return null;
  
        if(hp.containsKey(root)) {
         return hp.get(root);    
        }
        
        Tree newNode = new Tree(root.data);
        hp.put(root, newNode);
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);
        newNode.random = cloneTree(root.random);
        return newNode;
    }
}