/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursive call on the next node
        head.next = removeDuplicates(head.next);
        
        // Check if current node has same data as next node
        if (head.data == head.next.data) {
            // Skip the duplicate node
            return head.next;
        } else {
            // Keep current node
            return head;
        }
    }
}