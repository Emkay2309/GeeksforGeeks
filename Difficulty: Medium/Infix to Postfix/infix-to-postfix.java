import java.util.*;

class Solution {

    static int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }

    public static String infixToPostfix(String s) {

        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {

            // 1. Operand
            if (Character.isLetterOrDigit(ch)) {
                res.append(ch);
            }

            // 2. Opening bracket
            else if (ch == '(') {
                st.push(ch);
            }

            // 3. Closing bracket
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop(); // remove '('
            }

            // 4. Operator
            else {
                while (!st.isEmpty() &&
                      (precedence(st.peek()) > precedence(ch) ||
                      (precedence(st.peek()) == precedence(ch) && ch != '^'))) {
                    res.append(st.pop());
                }
                st.push(ch);
            }
        }

        // 5. Remaining operators
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }
}