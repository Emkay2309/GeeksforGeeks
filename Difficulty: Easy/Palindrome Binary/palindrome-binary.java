class Solution {
    public boolean isBinaryPalindrome(int n) {
        String str="";
        int i=0;
        while(n>0){
            int dig=n%2;
            str=str+(char)(dig);
            n=n>>1;
        }
        StringBuilder sb=new StringBuilder(str);
        return sb.reverse().toString().equals(str);
    }
};