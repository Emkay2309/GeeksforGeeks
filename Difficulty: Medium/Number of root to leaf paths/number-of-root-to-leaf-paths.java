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
} */

class Solution {
    void countPaths(Node root) {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
    	count(root,map,1);
    	for(int i : map.keySet()){
    	    System.out.print(i+" "+map.get(i)+" $");
    	}
    }
    void count(Node root,HashMap<Integer,Integer>map,int s){
        if(root == null)return;
        if(root.left == null && root.right == null){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        count(root.left,map,s+1);
        count(root.right,map,s+1);
    }
}