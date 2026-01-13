class Solution {
    public boolean canServe(int[] arr) {
        int five = 0;
        int ten = 0;

        for (int a : arr) {
            if (a == 5) {
                five++;
            } 
            else if (a == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } 
            else { // a == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
