class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        int count = 0;
        
        for(int num : arr){
            if(num >= start && num <= end){
                count++;
            }
        }
        
        if((end - start + 1) == count) return true;
        return false;
    }
}