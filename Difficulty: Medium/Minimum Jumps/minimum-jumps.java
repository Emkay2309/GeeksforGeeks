//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        
        int l=0,r=0,jumps=0,maxReach=0;
        
        while(r < n-1){
            maxReach=0;
            for(int i=l;i<=r;i++){
                maxReach=Math.max(maxReach,arr[i]+i);
            }
            if(maxReach==r)return -1;
            l=r+1;
            r=maxReach;
            jumps++;
        }
        
        return jumps;
    }
}