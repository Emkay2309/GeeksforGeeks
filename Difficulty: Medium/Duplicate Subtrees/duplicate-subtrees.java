class Solution {
    public List<Node> printAllDups(Node root) {
        // code here
        ArrayList<Node> result = new ArrayList<>();
        Map<String, Integer> sm = new HashMap<>();
        
        helper(root, result, sm);
        
        return result;
    }
    
    String helper(Node root, ArrayList<Node> result, Map<String, Integer> sm) {
        
        if( root == null) {
            return "#";
        }
        
        String left = helper(root.left, result, sm);
        String right = helper(root.right, result, sm);
        String serialized = left + "," + root.data + ","  + right;
        
        sm.put(serialized, sm.getOrDefault(serialized, 0) + 1);
        
        if(sm.get(serialized) == 2){
            result.add(root);
        }
        
        return serialized;

    }
}