// User function Template for Java

class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> AllPossibleStrings(String s) {
        
        solve( "" , s );
        Collections.sort(ans);
        return ans;
    }
    
    public void solve( String curr , String s) {
        if(s.length() == 0) {
            if(!curr.equals("")) {
                ans.add(curr);
            }
            return;
        }
        
        char ch = s.charAt(0);
        
        //new String 
        String newString = s.substring(1);
        
        //pick
        solve(curr+ch , newString);
        
        //not pick 
        solve(curr , newString);
    }
}