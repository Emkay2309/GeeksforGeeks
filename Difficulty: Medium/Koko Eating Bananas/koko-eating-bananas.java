class Solution {
    public int kokoEat(int[] arr, int k) {
        int l = 1, r = (int)1e6 + 1;
        int res = r;
        
        while(l < r){
            int s = l + (r - l) /2 ;
            if(finished(arr, k, s)) {
                res = s;
                r = s;
            }else l = s + 1;
        }
        return res;
    }
    
    private boolean finished(int[] arr, int k, int s){
        
        int hours = 0;
        for(int a: arr){
            hours += (a % s != 0) ? a / s + 1: a / s;
        }
        return hours <= k;
    }
}