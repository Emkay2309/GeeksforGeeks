class Solution {
    Node compute(Node head) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively process the rest of the list
        Node nextNode = compute(head.next);
        
        // If the next node is greater than current node, skip current node
        if (nextNode != null && nextNode.data > head.data) {
            return nextNode;
        }
        
        // Otherwise, keep current node and link it to the processed next node
        head.next = nextNode;
        return head;
    }
}