class Solution {
    public int bitonic(int[] arr) {
        int in[]=new int[arr.length];
        int de[]=new int[arr.length];
        in[0]=1;
        de[arr.length-1]=1;
        for(int i=1;i<arr.length;i++){
            in[i]=(arr[i]>=arr[i-1])?in[i-1] + 1 :1;
            
        }
        for(int i=arr.length-2;i>=0;i--){
            de[i]= (arr[i]>=arr[i+1])?de[i+1]+1:1;
            
        }
        
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,in[i]+de[i]-1);
        }
        return max;
    }
}