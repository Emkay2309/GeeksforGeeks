//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
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

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int [] arr) {
        int maxSoFar = Integer.MIN_VALUE; // Stores the maximum sum so far
        int currentMax = 0;               // Tracks the current subarray sum

        for (int ele : arr) {
            currentMax += ele;           // Add the current element to the current sum
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;   // Update maxSoFar if currentMax is greater
            }
            if (currentMax < 0) {
                currentMax = 0;          // Reset currentMax to 0 if it becomes negative
            }
        }

        return maxSoFar;                 // Return the maximum sum found
    }
}

