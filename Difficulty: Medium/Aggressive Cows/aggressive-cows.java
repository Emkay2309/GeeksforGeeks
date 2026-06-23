class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int st : stalls){
            l = Math.min(l, st);
            r = Math.max(r, st);
        }
        r = r-l;
        l = 0;
        
        int ans = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isAns(stalls, k, mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
    
    public boolean isAns(int[] stalls, int cows, int ans){
        int prev = stalls[0]; // pos of first cow
        cows--;
        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-prev >= ans){
                cows--; // place a cow here
                prev = stalls[i];
            }
        }
        return cows<=0; // all cows placed? true : false
    }
}