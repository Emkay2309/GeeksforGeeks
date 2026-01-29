class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        Queue<Integer> helper = new LinkedList<>();
        int n = q.size(); 
        for(int i = 0; i< n/2;i++){
            helper.add(q.remove());
        }
        while(!helper.isEmpty()){
            q.add(helper.remove());
            q.add(q.remove());
        }
    }
}
