/*Complete The given function
The Node class is as follows:
class Node{
    int data;
    Node left,right;

    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}*/
class Solution {
    public ArrayList<Integer> extremeNodes(Node root) {
        // add code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        
        q.add(root);
        
        while (q.size() > 0) {
            int n = q.size();
            
            for (int i = 1; i <= n; i++) {
                Node temp = q.remove();
                
                if (count % 2 == 0) {
                    if (i == n) {
                        ans.add(temp.data);
                    }
                }
                else {
                    if (i == 1) {
                        ans.add(temp.data);
                    }
                }
                
                if (temp.left != null) {
                    q.add(temp.left);
                }
                
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            
            count++;
        }
        
        return ans;
    }
}