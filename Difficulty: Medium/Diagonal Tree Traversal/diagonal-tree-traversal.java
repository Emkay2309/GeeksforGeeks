/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree {
    ArrayList<Integer> ans;
    Map<Integer,ArrayList<Integer>> map;
    public ArrayList<Integer> diagonal(Node root) {
        ans = new ArrayList<>();
        map = new TreeMap<>();
        
        dfs(root , 0);
        for (int key : map.keySet()) {
            ans.addAll(map.get(key));
        }
        return ans;
    }
    
    public void dfs(Node root , int level ) {
        if(root == null) return;
        
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.data);

        dfs(root.left  , level+1);
        dfs(root.right , level);
    }
}