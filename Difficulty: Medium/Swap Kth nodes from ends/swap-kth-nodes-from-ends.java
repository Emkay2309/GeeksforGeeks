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
    public Node swapKth(Node head, int k) {
        int len = getLen(head);
        if(k > len || k == len-k+1) return head;
        
        
        Node first = getKNode(head , k);
        Node last = getKNode(head , len-k+1);
        
        int temp = first.data;
        first.data = last.data;
        last.data = temp;
        
        return head;
    }
    
    public Node getKNode(Node head , int k) {
        if(k==1) return head;
        return getKNode(head.next , k-1);
    }
    
    public int getLen(Node head) {
        if(head == null) return 0;
        return 1 + getLen(head.next);
    }
}
