class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int n = arr.length;
        int cnt = 0, flip = 0;
        Queue<Integer> q = new LinkedList<>();
    
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peek() == i) {
                q.poll();
                flip ^= 1;
            }
            if ((arr[i] ^ flip) == 0) { // bit is 0 considering flips
                if (i + k > n) return -1;
                cnt++;
                flip ^= 1;
                q.add(i + k);
 
            }
        }
        return cnt;
    }
}
