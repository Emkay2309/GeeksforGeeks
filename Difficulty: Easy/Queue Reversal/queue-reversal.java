class Solution {
    public void reverseQueue(Queue<Integer> q) {
        if(q.isEmpty()) return;
        int curr = q.poll();
        reverseQueue(q);
        q.add(curr);
    }
    
    public void dfs(Queue<Integer> q) {
        
    }
}