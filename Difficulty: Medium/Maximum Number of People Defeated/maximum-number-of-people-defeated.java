class Solution {
    int maxPeopleDefeated(int p) {
        int ans = 0;
        int currentPower = p;
        
        for (int i = 1; i * i <= currentPower; i++) {
            currentPower -= i * i;
            ans++;
        }
        
        return ans;
    }
}