/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
    
    Hashmap<Integer,INteger> 
    HashMap<Node , INteger> 
    
    map -->  0 -  10
            -1- 20
            -2- 40
            1 - 30
            2 - 100
}
*/

class Solution {
    ArrayList<Integer> ans;
    public ArrayList<Integer> topView(Node root) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        
        int min = 0 , max = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root , 0)); // (10,0)
        Map<Integer,Integer> map = new HashMap<>();
        
        while(!q.isEmpty()) {
            Pair curr = q.poll(); //   (10,0) .; (20,-2)
            Node currNode = curr.node; //10 , 20
            int hd = curr.hd; //0  , -2
            
            min = Math.min(hd , min);
            max = Math.max(hd , max);
            
            if(map.containsKey(hd) == false) {
                map.put(hd , currNode.data);  // 0 -> 10
            }
            
            
            if(currNode.left != null) {
                q.add(new Pair(currNode.left , hd-1)); // (20,-1)
            }
            if(currNode.right != null) {
                q.add(new Pair(currNode.right , hd+1)); // (30,1)
            }
        }
        
        for(int i=min ; i<=max ; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}

class Pair {
    Node node;
    int hd;
    Pair(Node node , int hd) {
        this.node = node;
        this.hd = hd;
    }
}