class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<Integer>();
        int n=arr.length;
        for(int i=0;i<n;i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]) dq.pollLast();
            dq.addLast(i);
            if(i>=k-1) ans.add(arr[dq.peekFirst()]);
        }
        return ans;
    }
}