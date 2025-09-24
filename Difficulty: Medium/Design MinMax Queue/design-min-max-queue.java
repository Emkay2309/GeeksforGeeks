class SpecialQueue {
    private Deque<Integer> queue;
    private Deque<Integer> minDeque;
    private Deque<Integer> maxDeque;
    public SpecialQueue() {
        queue=new LinkedList<Integer>();
        minDeque=new ArrayDeque<Integer>();
        maxDeque=new ArrayDeque<Integer>();
    }

    public void enqueue(int x) {
       queue.addLast(x);
       while(minDeque.isEmpty()==false && minDeque.getLast()>x){
           minDeque.removeLast();
       }
       minDeque.addLast(x);
       while(maxDeque.isEmpty()==false && maxDeque.getLast()<x){
           maxDeque.removeLast();
       }
       maxDeque.addLast(x);
    }

    public void dequeue() {
        if(queue.size()==0){
            return;
        }
        int x=queue.removeFirst();
        if(minDeque.getFirst()==x){
            minDeque.removeFirst();
        }
        if(maxDeque.getFirst()==x){
            maxDeque.removeFirst();
        }
    }

    public int getFront() {
       if(queue.size()==0){
           return -1;
       }
       return queue.peekFirst();
    }

    public int getMin() {
        if(minDeque.size()==0){
           return -1;
       }
       return minDeque.peekFirst();
    }

    public int getMax() {
        if(maxDeque.size()==0){
           return -1;
       }
       return maxDeque.peekFirst();
    }
}