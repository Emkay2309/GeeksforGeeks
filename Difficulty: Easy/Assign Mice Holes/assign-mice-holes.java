import java.util.*;
class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // code here
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        int maxTime = Integer.MIN_VALUE;
        
        for(int i = 0; i<mices.length; i++){
            int ans = Math.abs(mices[i] - holes[i]);
            
            if(maxTime < ans){
                maxTime = ans;
            }
        }
        
        return maxTime;
    }
};