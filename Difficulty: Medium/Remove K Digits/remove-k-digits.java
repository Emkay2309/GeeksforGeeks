class Solution {
    public String removeKdig(String s, int k) {
        // code here
        int n = s.length();
        int[] v = new int[10];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && s.charAt(i) < st.peek() && k > 0) {
                st.pop();
                k--;
            }
            if (st.isEmpty() && s.charAt(i) == '0') {
                continue;
            }
            st.push(s.charAt(i));
        }

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}