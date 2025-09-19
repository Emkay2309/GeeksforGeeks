class Solution {
    public int minParentheses(String s) {
        // code here
        int o = 0 , c = 0 , ans=0;
        
        for(char ch : s.toCharArray()) {
            if(ch=='(') o++;
            else {
                if(o>0) {
                    o--;
                }
                else{
                    ans++;
                }
            }
        }
        
        return ans+o;
    }
}
