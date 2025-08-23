
class Solution {
    static void reverse(Stack<Integer> St) {
        if(St.isEmpty()) return;
        
        int top = St.pop(); // Pops: 5 → 4 → 3 → 2 → 1 (one by one during recursive calls)

        reverse(St);  // Keeps calling until stack becomes empty

        insertAtBottom(St , top);  
        // On the way back:
        // [] → insert 5 → [5]
        // [5] → insert 4 → [4, 5]
        // [4,5] → insert 3 → [3, 4, 5]
        // [3,4,5] → insert 2 → [2, 3, 4, 5]
        // [2,3,4,5] → insert 1 → [1, 2, 3, 4, 5]
    }
    
    static void insertAtBottom(Stack<Integer> st , int data) {
        if(st.isEmpty()) {
            st.push(data);
            return;
        }
        
        int top = st.pop(); // Pops elements until stack becomes empty (to reach the bottom) // 5

        insertAtBottom(st , data);  // []4 -> goes to base case add 4 
        // Inserts `data` at the bottom once stack is empty
        // Then while recursion unwinds:
        // pushes back top elements in reverse order

        st.push(top);  // [4,5]
        // Rebuilds the stack upwards with original order above the new bottom
    }
}
