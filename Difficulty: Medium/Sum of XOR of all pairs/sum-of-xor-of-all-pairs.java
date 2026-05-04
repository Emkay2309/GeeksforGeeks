class Solution {
    public long sumXOR(int[] arr) {
        // code here
        long ans=0l;
        
        for(int i=31;i>=0;i--){
            long count1=0l;
            long count2=0l;
            for(int j=0;j<arr.length;j++){
              if((arr[j]&(1<<i))!=0){
                  count1+=1l;
              }
              else{
                  count2+=1l;
              }
                
            }
            long sum=(count1*count2*(1l<<i));
            ans+=sum;
            
        }
        return ans;
    }
}