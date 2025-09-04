/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        
        Node curr = head;
        int c = 0;
        
        while(curr != null && c<k) {
            curr = curr.next;
            c++;
        }
        
        if (c == k) {
            Node reversedList = reverse(head, k);
            head.next = reverseKGroup(curr, k);
            return reversedList;
        } else {
            if (c == 0) return head;  
            Node reversedList = reverse(head, c);
            return reversedList;
        }

 
    }
    
    public Node reverse(Node head , int k) {
        if (k == 1 || head.next == null ) {
            return head;
        }
        
        Node last = reverse(head.next , k-1);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

