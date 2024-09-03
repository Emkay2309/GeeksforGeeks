//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution  {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)   {
        int [] dist = new int [V];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[S]  = 0;
        boolean [] vis = new boolean [V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.wt-y.wt);
        pq.add(new Pair(S,0));
        
        
        while( !pq.isEmpty() ) {
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currWt = curr.wt;
            
            if(vis[currNode]) continue;
            
            vis[currNode] = true;
            
            ArrayList<ArrayList<Integer>> neighList = adj.get(currNode);
            
            for(ArrayList<Integer> neigh : neighList) {
                int neighNode = neigh.get(0);
                int neighWt = neigh.get(1);
                
                if(dist[neighNode] > dist[currNode] + neighWt) {
                    dist[neighNode] = dist[currNode] + neighWt;
                    
                    pq.add(new Pair(neighNode , dist[neighNode]));
                }
            }
        }
        
        return dist;
    }
}

class Pair {
    int node;
    int wt;
    
    Pair(int node , int wt) {
        this.node = node;
        this.wt = wt;
    }
}

