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
    public int lengthOfLoop(Node head) {
        // code here
        if (head == null) return 0;
        
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // cycle detected
            if (slow == fast) {
                return countLoopLength(slow);
            }
        }
        return 0;
    }
    
    public int countLoopLength(Node meetingPoint) {
        Node curr = meetingPoint;
        int count = 1;
        while(curr.next != meetingPoint) {
            curr = curr.next;
            count++;
        }
        return count;
    }
}