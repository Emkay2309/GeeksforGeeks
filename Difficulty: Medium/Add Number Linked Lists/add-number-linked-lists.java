/* node for linked list

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
    static Node addTwoLists(Node num1, Node num2) {
        Node ans = new Node(-1);
        Node curr = ans;
        
        int carry = 0;
        
        num1 = reverseLL(num1);
        num2 = reverseLL(num2);
        
        while(num1 != null || num2 != null || carry > 0) {
            int val1 = (num1 != null) ? num1.data : 0;
            int val2 = (num2 != null) ? num2.data : 0;
            
            int currSum = val1 + val2 + carry;
            carry = currSum/10;
            int add = currSum%10;
            
            Node newNode = new Node(add);
            curr.next = newNode;
            
            if(num1 != null) {
                num1 = num1.next;
            }
            if(num2 != null) {
                num2 = num2.next;
            }
            
            curr = curr.next;
        }
        ans = reverseLL(ans.next);
        while(ans != null && ans.data == 0) {
            ans = ans.next;
        }
        return ans;
        
    }
    
     static Node reverseLL(Node head) {
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