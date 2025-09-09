class Solution {
    public String largestSwap(String s) {
        // code here
        int n = s.length();
        char [] nums = s.toCharArray();
        int  [] last = new int [10];
        
        for(int i=0 ; i<n ; i++) {
            int curr = s.charAt(i)-'0';
            last[curr] = i;
        }
        
        
        for(int i=0 ; i<nums.length ; i++) {
            int curr = s.charAt(i)-'0';
            
            for(int j=9 ; j>curr  ; j--) {
                
                if(last[j] > i) {
                    char temp = nums[i];
                    nums[i] = nums[last[j]];
                    nums[last[j]] = temp;
                    return new String (nums);
                }
            }
        }
        return s;
    }
}