// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca = findLCA(root , a , b);
        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);
        return d1 + d2;
    }
    // Function to find LCA
    private Node findLCA(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;

        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if (left != null && right != null) return root; // found both sides
        return (left != null) ? left : right;
    }

    // Function to find distance from given node to target
    private int findLevel(Node root, int k, int level) {
        if (root == null) return -1;
        if (root.data == k) return level;

        int left = findLevel(root.left, k, level + 1);
        if (left != -1) return left;

        return findLevel(root.right, k, level + 1);
    }
}