class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
        int m = mat[0].length;
        int n = mat.length;
         for(int i=0; i<n; i++){
            int j = m - 1 - i;
            int temp = mat[i][i];
            mat[i][i] = mat[i][j];
            mat[i][j] = temp;
        }
    }
}