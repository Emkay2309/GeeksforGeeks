/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        // TreeMap to store vertical sums in sorted order of horizontal distances
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Perform recursive DFS
        verticalSumHelper(root, 0, map);
        
        // Convert map values to ArrayList
        ArrayList<Integer> result = new ArrayList<>(map.values());
        return result;
    }
    
    private void verticalSumHelper(Node node, int horizontalDistance, 
                                  TreeMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        
        // Add current node's data to its vertical line sum
        map.put(horizontalDistance, 
                map.getOrDefault(horizontalDistance, 0) + node.data);
        
        // Recurse for left child (horizontal distance decreases by 1)
        verticalSumHelper(node.left, horizontalDistance - 1, map);
        
        // Recurse for right child (horizontal distance increases by 1)
        verticalSumHelper(node.right, horizontalDistance + 1, map);
    }
}