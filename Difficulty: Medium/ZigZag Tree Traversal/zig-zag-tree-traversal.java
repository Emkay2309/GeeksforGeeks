/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        
        q.add(root);
        
        
        while(!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(n-- > 0) {
                Node curr = q.poll();
                
                temp.add(curr.data);
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            if(level%2 != 0) Collections.reverse(temp);
            
            ans.addAll(temp);
            level++;
        }
        return ans;
        
    }
}