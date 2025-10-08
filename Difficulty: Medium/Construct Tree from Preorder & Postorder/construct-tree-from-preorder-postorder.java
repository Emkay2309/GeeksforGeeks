/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private Map<Integer, Integer> postOrderMap;

    public Node constructTree(int[] pre, int[] post) {

        if (pre == null || pre.length == 0) {
            return null;
        }

        postOrderMap = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postOrderMap.put(post[i], i);
        }
        return build(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private Node build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
 
        if (preStart > preEnd) {
            return null;
        }
        Node root = new Node(pre[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int leftSubVal = pre[preStart + 1];
        int postIndex = postOrderMap.get(leftSubVal);
        int leftSubtreeSize = postIndex - postStart + 1;
        root.left = build(pre, preStart + 1, preStart + leftSubtreeSize, 
                          post, postStart, postIndex);
        root.right = build(pre, preStart + leftSubtreeSize + 1, preEnd, 
                           post, postIndex + 1, postEnd - 1);

        return root;
    }
}