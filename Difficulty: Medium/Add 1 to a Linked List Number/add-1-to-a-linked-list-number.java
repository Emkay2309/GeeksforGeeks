/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverse(head);

        // Step 2: Add 1 to the number
        Node curr = head;
        int carry = 1; // Start with +1
        Node prev = null;

        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;

            prev = curr;
            curr = curr.next;
        }

        // Step 3: If carry is left, add new node
        if (carry > 0) {
            prev.next = new Node(carry);
        }

        // Step 4: Reverse again to restore order
        return reverse(head);
    }

    // Helper: reverse linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
