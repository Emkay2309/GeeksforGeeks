class Solution {
    
    Stack<Character> undo = new Stack<>();
    Stack<Character> redo = new Stack<>();
    
    StringBuilder s = new StringBuilder();
    
    public void append(char x) {
        // append x into document
        s.append(x);
        undo.push(x);
        redo.clear();
    }

    public void undo() {
        if(s.length() > 0){
            char removed = s.charAt(s.length() - 1);
            s.deleteCharAt(s.length() - 1); 
            undo.pop();
            redo.push(removed);
        }
    }

    public void redo() {
        if(!redo.isEmpty()){
            char restored = redo.pop();
            s.append(restored);
            undo.push(restored);
        }
    }

    public String read() {
        // read the document
       String result = s.toString(); 
       return result;
    }
}