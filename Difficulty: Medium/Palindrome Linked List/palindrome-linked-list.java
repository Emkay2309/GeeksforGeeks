/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public boolean isPalindrome(Node head) {
        if( head.next == null || head==null ) return true;
        
        if( head.next.next == null ) {
            if(head.data == head.next.data) {
                return true;
            }
            return false;
        }
        
        Node mid = FindMid(head);
        
        Node left = head;
        Node right = ReverseMid(mid);
        
        
        while( right != null ) {
            if( left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }   
    
    public Node ReverseMid ( Node mid ) {
        Node curr = mid;
        Node prev = null;
        Node next = null;
        
        while( curr != null) {
            
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
            
        }
        return prev;
    }
    
    public Node FindMid ( Node head) {
        Node slow = head;
        Node fast = head;
        
        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return  slow;
    }
}