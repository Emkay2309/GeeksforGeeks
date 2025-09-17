class Solution {
    static String decodeString(String s) {
        // code here
        int n = s.length();
        String ans = "";
        Stack<String> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        
        int index = 0;

        while( index < n)  {
            char ch = s.charAt(index);
            
            //if digits
            if(Character.isDigit(ch)) {
                //Create number
                int number = 0;

                while(Character.isDigit(s.charAt(index)))  {
                    int val = s.charAt(index) - '0';
                    number = number * 10 + val;
                    index++;
                }
                num.push(number);
            }
            // '['
            else if(ch == '[')  {
                str.push(ans);
                ans = "";
                index++;
            }
            //  ']'
            else if( ch == ']')  {
                //Create string
                String temp = str.pop();
                StringBuilder sb = new StringBuilder(temp);
                int times = num.pop();

                while(times > 0) {
                    sb.append(ans);
                    times--;
                }
                ans = sb.toString();
                index++;
            }
            //Character
            else {
                ans += ch;
                index++;
            }
        }
        return ans;
    }
}