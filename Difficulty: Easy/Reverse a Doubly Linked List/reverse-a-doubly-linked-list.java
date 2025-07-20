/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/

class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        if(head == null) return null;
        DLLNode curr = head;
        DLLNode prev = null;
        
        while(curr != null) {
            DLLNode temp = curr.next;
            
            curr.next = prev;
            curr.prev = temp;
            
            prev = curr;
            curr = temp;
        }
        
        return prev;
        
    }
}