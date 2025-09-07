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
    Node mergeKLists(Node[] arr) {
        // code here
        return mergek(0,arr.length-1 , arr);
    }
    
    Node mergek(int s , int e , Node [] arr) {
        if(s == e) return arr[s];
        
        int mid = (s+e)/2;
        
        Node left = mergek(s , mid , arr);
        Node right = mergek(mid+1 , e , arr);
        
        return merge(left , right);
    }
    
    Node merge(Node l1 , Node l2) {
        if(l1 == null) return l2;
        if(l2 == null ) return l1;
        

        if(l1.data <= l2.data) {
            l1.next = merge(l1.next , l2);
            return l1;
        }
        else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}