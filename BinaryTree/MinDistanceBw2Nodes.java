package BinaryTree;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class MinDistanceBw2Nodes {
    class Solution {
    int minDist(Node root, int x, int y) {
        Node lca = LCA(root, x, y);
        int dx = dist(lca, x);
        int dy = dist(lca, y);
        return dx + dy;
    }
    private int dist(Node root, int target) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.data == target) return 0;
        int leftDist = dist(root.left, target);
        int rightDist = dist(root.right, target);
        if (leftDist != Integer.MIN_VALUE) return leftDist + 1;
        if (rightDist != Integer.MIN_VALUE) return rightDist + 1;
        return Integer.MIN_VALUE;
    }
    private Node LCA(Node root, int x, int y) {
        if (root == null) return null;
        if (root.data == x || root.data == y) return root;
        Node leftLCA = LCA(root.left, x, y);
        Node rightLCA = LCA(root.right, x, y);
        if (leftLCA != null && rightLCA != null) return root;
        return leftLCA != null ? leftLCA : rightLCA;
    }
    }
}
