class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        // code here
        int n = seats.length;
        for(int i=0 ; i<seats.length-1 ; i++) {
            if(seats[i]==1 && seats[i+1]==1) return false;
        }
         int available_seats = 0;
        for (int i = 0; i < n; i++) {
            int prev = i == 0 ? 0 : seats[i - 1];
            int next = i == n - 1 ? 0 : seats[i + 1];
            if (prev + next + seats[i] == 0) {
                available_seats++;

                i++;
            }
        }
        return available_seats >= k;
    }
}