class Solution {
    public int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        
        int l=0,r=0,jumps=0,maxReach=0;
        
        while(r < n-1){
            maxReach=0;
            for(int i=l;i<=r;i++){
                maxReach=Math.max(maxReach,arr[i]+i);
            }
            if(maxReach==r)return -1;
            l=r+1;
            r=maxReach;
            jumps++;
        }
        
        return jumps;
    }
}