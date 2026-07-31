import java.util.*;

class LCAInBST {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node LCA(Node root, Node p, Node q) {
        if (root.data > p.data && root.data > q.data)
            return LCA(root.left, p, q);
        else if (root.data < p.data && root.data < q.data)
            return LCA(root.right, p, q);
        else
            return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}