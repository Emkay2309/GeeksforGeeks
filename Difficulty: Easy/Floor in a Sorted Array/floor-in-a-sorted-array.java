//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Searching {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String a[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            long x = Long.parseLong(a[(int)1]);
            String st[] = read.readLine().trim().split("\\s+");

            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st[i]);
            }

            out.println(new Solution().findFloor(arr, n, x));
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x) {
        int s = 0, e = n - 1;
        int ans = -1;  // Initialize to -1 as no valid floor found initially
        
        while (s <= e) {
            int mid = s + (e - s) / 2;
            
            if (arr[mid] == x) {
                return mid;  // If x is found, return the index of x (which is also its floor)
            }
            
            if (arr[mid] < x) {
                ans = mid;  // Potential floor, update ans
                s = mid + 1;  // Search right for a better candidate
            } else {
                e = mid - 1;  // Search left
            }
        }
        
        return ans;  // Return the index of the floor, or -1 if no floor exists
    }
}

