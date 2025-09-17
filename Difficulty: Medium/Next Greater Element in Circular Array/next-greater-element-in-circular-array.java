class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        // Initialize the result array with -1s
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        
        // Iterate over the array twice to simulate the circular behavior
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;  // Circular index
            // Find the next greater element for the elements in the stack
            while (!stack.isEmpty() && arr[currentIndex] > arr[stack.peek()]) {
                int index = stack.pop();
                result.set(index, arr[currentIndex]);
            }
            // Push the current index onto the stack if we are still in the first traversal
            if (i < n) {
                stack.push(currentIndex);
            }
        }
        
        return result;
    }
}