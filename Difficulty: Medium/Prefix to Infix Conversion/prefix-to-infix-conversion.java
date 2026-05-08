class Solution {
    static String preToInfix(String pre_exp) {
        Stack<String> stack=new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch))stack.push(String.valueOf(ch));
            else{
                String t1=stack.pop();
                String t2=stack.pop();
                stack.push("("+t1+ch+t2+")");
            }
        }
        return stack.pop();
    }
}