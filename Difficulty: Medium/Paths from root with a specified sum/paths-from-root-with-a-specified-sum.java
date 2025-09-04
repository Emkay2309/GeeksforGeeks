// User function Template for Java

/*Tree Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static ArrayList<ArrayList<Integer>> ans;
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        ans = new ArrayList<>();
        
        dfs(root , 0 , new ArrayList<>() , sum );
        return ans;
    }
    
    static void dfs(Node root , int currSum , ArrayList<Integer> path , int sum) {
        if(root == null) return;
        
        currSum += root.data;
        path.add(root.data);
        
        if(currSum == sum) {
            ans.add(new ArrayList<>(path));
        }
        
        dfs(root.left  , currSum , path , sum);
        dfs(root.right , currSum , path , sum);
        
        path.remove(path.size()-1);
    }
}