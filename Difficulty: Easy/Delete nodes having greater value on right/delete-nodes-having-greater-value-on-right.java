/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution {
    int max;
    Node compute(Node head) {
        max =  Integer.MIN_VALUE;
        return dfs( head );
    }
    
    Node dfs(Node head) {
        if(head == null) return null;
        
        head.next = dfs(head.next);
        
        if(head.data < max) {
            return head.next;
        }
        else {
            max = head.data;
            return head;
        }
    } 
}