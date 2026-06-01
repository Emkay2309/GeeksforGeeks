/*
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
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the rest of the list
        Node newHead = reverseList(head.next);
        
        // Reverse the connection
        // head.next is currently pointing to the next node
        // We want that next node to point back to head
        head.next.next = head;
        
        // Break the original forward connection
        head.next = null;
        
        // Return the new head of the reversed list
        return newHead;
    }
}