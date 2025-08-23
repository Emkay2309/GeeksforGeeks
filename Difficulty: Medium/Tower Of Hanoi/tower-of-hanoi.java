class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        // code here
        if(n == 0) return 0;
        return 2*towerOfHanoi(n-1,from,to ,aux) + 1;
    }
}
