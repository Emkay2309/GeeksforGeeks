class Solution {
    public boolean compute(Node root) {
        StringBuilder sb = new StringBuilder();
        
        Node curr = root;
        
        while(curr != null) {
            sb.append(curr.data);
            curr = curr.next;
        }
        
        int i=0 , j=sb.length()-1;
        
        while( i <= j) {
            char s = sb.charAt(i);
            char e = sb.charAt(j);
            
            if(s != e) return false;
            
            i++;
            j--;
        }
        return true;
    }
}