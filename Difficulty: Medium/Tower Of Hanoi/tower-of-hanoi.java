class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        // code here
        if(n == 0 || n == 1) return n;
        return (int) Math.pow(2,n)-1;
    }
}
