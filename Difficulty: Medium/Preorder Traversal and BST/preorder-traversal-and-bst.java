import java.util.*;

class Solution {
    static int canRepresentBST(int arr[], int N) {
        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            // Right subtree element smaller than lower bound → invalid
            if (arr[i] < lowerBound) {
                return 0;
            }
            
            // Pop all left subtree elements (smaller than current)
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                lowerBound = stack.pop();
            }
            
            stack.push(arr[i]);
        }
        return 1;
    }
}