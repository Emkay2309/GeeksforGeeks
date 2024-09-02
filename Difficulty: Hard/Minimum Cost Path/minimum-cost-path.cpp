//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
    public:
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    int minimumCostPath(vector<vector<int>>& grid) 
    {
        // Code here
        int n=grid.size();
        int m =grid[0].size();
        int dp[n+1][m+1];
        //memset(dp,INT_MAX-1,sizeof(dp));
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
              dp[i][j]=INT_MAX;
            }
        }
        
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1){
                    dp[i][j]=grid[i-1][j-1];
                }
                else if(j==m and i==n){
                     dp[i][j]=grid[i-1][j-1]+min(dp[i][j-1],dp[i-1][j]);
                }
                else if(j==m){
                    dp[i][j]=grid[i-1][j-1]+min(dp[i][j-1],min(dp[i-1][j],dp[i+1][j]));
                }
                else if(i==n){
                    dp[i][j]=grid[i-1][j-1]+min(dp[i][j-1],min(dp[i][j+1],dp[i-1][j]));
                }
                else {
                dp[i][j]=grid[i-1][j-1]+min(dp[i][j-1],min(dp[i][j+1],min(dp[i-1][j],dp[i+1][j])));
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1){
                    dp[i][j]=grid[i-1][j-1];
                }
                else if(j==m and i==n){
                     dp[i][j]=grid[i-1][j-1]+min(dp[i][j-1],dp[i-1][j]);
                }
                else if(j==m){
                    dp[i][j]=grid[i-1][j-1]+min(dp[i][j-1],min(dp[i-1][j],dp[i+1][j]));
                }
                else if(i==n){
                    dp[i][j]=grid[i-1][j-1]+min(dp[i][j-1],min(dp[i][j+1],dp[i-1][j]));
                }
                else {
                dp[i][j]=grid[i-1][j-1]+min(dp[i][j-1],min(dp[i][j+1],min(dp[i-1][j],dp[i+1][j])));
                }
            }
        }
        return dp[n][m];
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>grid(n, vector<int>(n, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.minimumCostPath(grid);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends