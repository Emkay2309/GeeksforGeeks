//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // Lists to store positive and negative numbers separately
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        
        // Separate the elements into positive and negative lists
        for (int num : arr) {
            if (num >= 0) {
                posList.add(num);
            } else {
                negList.add(num);
            }
        }
        
        int pos = 0, neg = 0;
        int i = 0;
        int n = arr.size();
        
        // Alternate between positive and negative numbers
        while (pos < posList.size() && neg < negList.size()) {
            if (i % 2 == 0) {
                arr.set(i, posList.get(pos));
                pos++;
            } else {
                arr.set(i, negList.get(neg));
                neg++;
            }
            i++;
        }
        
        // Add the remaining positive numbers, if any
        while (pos < posList.size()) {
            arr.set(i, posList.get(pos));
            pos++;
            i++;
        }
        
        // Add the remaining negative numbers, if any
        while (neg < negList.size()) {
            arr.set(i, negList.get(neg));
            neg++;
            i++;
        }
    }
}
