//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int [] a : edges) {
            int sv = a[0];
            int ev = a[1];
            
            adj.get(sv).add(ev);
            adj.get(ev).add(sv);
        }
        return bfs(src , n , m , adj);
    }
    
    public int [] bfs(int src , int n , int m , ArrayList<ArrayList<Integer>> adj )  {
        
        int [] dist = new int [n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int neigh : adj.get(curr)) {
                if(dist[neigh] > 1 + dist[curr]) {
                    dist[neigh] = 1 + dist[curr];
                    q.add(neigh);
                }
            }
        }
        
        for(int i=0 ; i<dist.length ; i++ ) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    
    
}