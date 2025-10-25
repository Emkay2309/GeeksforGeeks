class Solution {
    public int minOperations(int[] arr) {
        int operations = 0; // operations performed so far
        double sum = 0; // to evaluate the sum
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a)); // max-heap
        for(int i=0; i<arr.length; i++){
            sum += arr[i]; // update sum
            pq.add((double)arr[i]); // insert to max-heap
        }
        double target = sum/2; // sum must be halved or at least less than half
        while(sum>target){ // till sum > target
            double a = pq.poll(); // largest from pq
            a = a/2; // halved
            sum -= a; // reduce the sum
            pq.offer(a); // again insert to pq
            operations++; // increment operations 
        }
        return operations; // min operations
    }
}