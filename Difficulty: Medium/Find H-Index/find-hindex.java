class Solution {
    public int hIndex(int[] citations) {
        // code here
        int n = citations.length;
        Arrays.sort(citations);
        int max = 0;
        
        for(int i=0 ; i<n ; i++) {
            int h = Math.min(citations[i] , n-i);
            max = Math.max(max , h);
        }
        return max;
    }
}