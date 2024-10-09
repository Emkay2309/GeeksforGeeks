//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        
        Arrays.sort(arr);
        // code here
        int floor = -1;
        int ceil = -1;
        
        int s = 0 , e = arr.length-1;
        
        while( s <= e) {
            int mid = (s+e)/2;
            
            if(arr[mid] == x) {
                return new int [] {x , x};
            }
            
            if(arr[mid] >= x) {
                ceil = mid;
                e = mid-1;
            }
            else if(arr[mid] <= x) {
                floor = mid;
                s = mid+1;
            }
        }
        return new int [] {floor == -1 ? -1 : arr[floor] , ceil != -1 ? arr[ceil] : -1};
    }
}
