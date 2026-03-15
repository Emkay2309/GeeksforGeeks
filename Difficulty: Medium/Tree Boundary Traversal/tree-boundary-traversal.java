/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    void addLeftBoundary(Node node, ArrayList<Integer> res) {
        while (node != null) {
            if (!isLeaf(node))
                res.add(node.data);

            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    void addLeaves(Node node, ArrayList<Integer> res) {
        if (node == null) return;

        if (isLeaf(node)) {
            res.add(node.data);
            return;
        }

        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    void addRightBoundary(Node node, ArrayList<Integer> res) {
        Stack<Integer> st = new Stack<>();

        while (node != null) {
            if (!isLeaf(node))
                st.push(node.data);

            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        while (!st.isEmpty())
            res.add(st.pop());
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root))
            res.add(root.data);

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);

        return res;
    }
}