class Solution {
    public static int minCost(int[] arr) {
        // code here
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num:arr){
            minHeap.add(num);
        }
        int total =0;
        while(minHeap.size() > 1){
            int num1 = minHeap.poll();
            int num2 = minHeap.poll();
            
            int cost =num1+num2;
            total += cost;
            minHeap.add(cost);
        }
        
        return total;
    }
}