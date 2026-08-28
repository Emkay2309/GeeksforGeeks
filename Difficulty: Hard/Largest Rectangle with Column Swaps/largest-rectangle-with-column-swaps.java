class Solution {
    public int maxArea(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        int[] hist = new int[m];

        // for(int j = 0; j < m; j++){
        //     hist[0][j] = mat[0][j] == 1 ? 1 : 0;
        // }
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    hist[j]++;
                } else {
                    hist[j] = 0;
                }
            }

            //instead of standard sort we will use count sort
            //max height can be n
            int[] count = new int[n + 1];
            for(int j = 0; j < m; j++){
                count[hist[j]]++;
            }
            int wt = 0;
            for(int h = n; h >= 1; h--){
                if(count[h] > 0){
                    wt += count[h];
                    ans = Math.max(ans, wt * h);
                }
            }
        }
        return ans;
    }
}