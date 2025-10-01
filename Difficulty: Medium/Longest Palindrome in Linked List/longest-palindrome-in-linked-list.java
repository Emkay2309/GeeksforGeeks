/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}*/
class Solution {
    public static int maxPalindrome(Node head) {
        // add code here.
        Node curr = head;
        int ans = 0;
        Node prev = null;
        
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            
            int len1 = 1 + check(prev , next);
            int len2 = check(curr , next);
            
            ans = Math.max(ans , Math.max(len1 , len2));
            
            prev = curr;
            curr = next;
        }
        return ans;
    }
    
    public static int check(Node a , Node b) {
        int count = 0;
        while(a!=null && b!=null) {
            if(a.data == b.data) {
                a=a.next;
                b=b.next;
                count += 2;
            }
            else {
                break;
            }
        }
        return count;
    }
}