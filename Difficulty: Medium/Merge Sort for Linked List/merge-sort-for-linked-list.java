/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/
class Solution {
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        
        // Split the list into two halves
        Node mid = getMiddle(head);
        Node rightHead = mid.next;
        mid.next = null; // break into two lists

        // Recursively sort
        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        // Merge sorted halves
        return merge(left, right);
    }

    // Utility: find middle (slow/fast pointer)
    private Node getMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists
    private Node merge(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.data <= l2.data) {
            l1.next = merge(l1.next , l2);
            return l1;
        }
        else {
            l2.next = merge(l1 , l2.next);
            return l2;
        }
    }
}
