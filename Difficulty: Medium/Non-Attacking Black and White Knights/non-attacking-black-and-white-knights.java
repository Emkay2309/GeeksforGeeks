class Solution {
    public int numOfWays(int n, int m) {
        // code here
        int totalCell = n * m;
        int ways = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int[][] attackingCells = {{i-1,j+2},{i+1,j+2},{i+2,j+1},{i+2,j-1},{i+1,j-2},{i-1,j-2},{i-2,j+1},{i-2,j-1}};
                int countValidCell = 0;
                
                for(int[] cell : attackingCells){
                    int r = cell[0];
                    int c = cell[1];
                    if(r >= 0 && r < n && c >= 0 && c < m){
                        countValidCell++;
                    }
                }
                ways += (totalCell - countValidCell - 1);
            }
        }
        return ways;
    }
}