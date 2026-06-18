class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int n=mat.length, m = mat[0].length;
        int tot=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    int c=0;
                    //left
                    for(int k=j-1;k>=0;k--){
                        if(mat[i][k]==1){
                            c++;
                            break;
                        }
                    }
                    //right
                    for(int k=j+1;k<m;k++){
                        if(mat[i][k]==1){
                            c++; break;
                        }   
                    }
                    //top
                    for(int k=i-1;k>=0;k--){
                        if(mat[k][j]==1){
                            c++;
                            break;
                        }
                    }
                    for(int k=i+1;k<n;k++){
                        if(mat[k][j]==1){
                            c++;
                            break;
                        }
                    }
                    tot+=c;
                }
            }
        }
        return tot;
    }
}