/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node reverseList(Node head) {
        // code here
        if(head==null || head.next==null) return head;
        
        Node newHead = reverseList(head.next);
        head.next.next = head; //4.next = 3
        head.next = null; // 3.next = null
        
        return newHead;
    }
}