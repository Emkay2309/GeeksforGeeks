class Solution {
    public boolean isPower(int x, int y) {
        if (y == 1) return true;
        
        if (x == 1) return false;

        if (y < x) return false;
        
        if (y % x != 0) return false;

        return isPower(x, y / x);
    }
}