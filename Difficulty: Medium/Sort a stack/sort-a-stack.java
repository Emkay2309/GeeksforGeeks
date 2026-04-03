class Solution {
    public void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;
        
        int top = st.pop();
        sortStack(st);
        sortedInsert(st, top);
    }
    
    private void sortedInsert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }
        
        int top = st.pop();
        sortedInsert(st, x);
        st.push(top);
    }
}
