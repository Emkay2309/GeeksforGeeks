class Solution {
    public int maxSum(int n) {
        // code here.
        if(n <= 1 ) return n;
        int two = maxSum(n/2);
        int three = maxSum(n/3);
        int four = maxSum(n/4);
        
        return Math.max(n , two + three + four);
    }
}
