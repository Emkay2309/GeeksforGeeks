class Solution {
    
    void genSubsets(int idx, int sum, int arr[], Map<Integer, Integer> map){
        
        if(idx == arr.length){
            map.put(sum, map.getOrDefault(sum , 0) + 1);
            return;
        } 
        
        // Include in our subset:
        genSubsets(idx+1, sum+arr[idx], arr, map);
        
        // Not Include in our subset:
        genSubsets(idx+1, sum, arr, map);
        
        
    }
    public int countSubset(int[] arr, int k) {
        
        int n = arr.length;
        int mid = n/2;
        
       int left[] = new int[mid];
       int right[] = new int[n-mid];
       
       
       for(int i=0; i<mid; i++){
           left[i] = arr[i];
       }
       
       int j = 0;
       for(int i=mid; i<n; i++){
           right[j++] = arr[i];
       }
       
       Map<Integer, Integer> leftFreq = new HashMap<>();
       Map<Integer, Integer> rightFreq = new HashMap<>();
       
       genSubsets(0, 0, left, leftFreq);
       genSubsets(0, 0, right, rightFreq);
       
       
       int ans = 0;
       
       for(Map.Entry<Integer, Integer> mp: leftFreq.entrySet()){
           
           int leftSum = mp.getKey();
           int leftF = mp.getValue();
           
           if(rightFreq.containsKey(k-leftSum)){
               ans += leftF*rightFreq.get(k-leftSum);
           }
       }
       
       return ans;
    }
}