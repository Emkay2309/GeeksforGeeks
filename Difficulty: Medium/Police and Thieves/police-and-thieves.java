class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        
        int i = 0;
        int j = 0;
        
        int n = arr.length;
        int maxCaughtThieves = 0;
        
        
        while((i < n) && (j < n)){
            
            if(arr[j] == 'P'){
                if(arr[i] == 'T' && Math.abs(i - j) <= k){
                    
                    maxCaughtThieves++;
                    i++;
                    j++;
                }else{
                    while((i < n) && (arr[i] == 'P')){
                        i++;
                    }
                    if((i < n) && (arr[i] == 'T' && Math.abs(i - j) <= k)){
                       maxCaughtThieves++;
                       i++;
                       j++;
                    }else{
                        if(i > j){
                           j++;
                        }else{
                           i++;
                        }
                    }
                }
            }else{
                j++;
            }
        }
        return maxCaughtThieves;
    }
}

