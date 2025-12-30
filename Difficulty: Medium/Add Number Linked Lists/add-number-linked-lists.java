/*
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
    Node addTwoLists(Node head1, Node head2) {
        Node ans = new Node(-1);
        Node curr = ans;
        
        int carry = 0;
        
        head1 = reverseLL(head1);
        head2 = reverseLL(head2);
        
        while(head1 != null || head2 != null || carry > 0) {
            int val1 = (head1 != null) ? head1.data : 0;
            int val2 = (head2 != null) ? head2.data : 0;
            
            int currSum = val1 + val2 + carry;
            carry = currSum/10;
            int add = currSum%10;
            
            Node newNode = new Node(add);
            curr.next = newNode;
            
            if(head1 != null) {
                head1 = head1.next;
            }
            if(head2 != null) {
                head2 = head2.next;
            }
            
            curr = curr.next;
        }
        ans = reverseLL(ans.next);
        while(ans != null && ans.data == 0) {
            ans = ans.next;
        }
        return ans;
        
    }
    
    Node reverseLL(Node head) {
        Node prev = null; 
        Node curr = head;
        
        while(curr!=null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}