import java.util.*;

class DeleteTreeNode {

    class Node {
        Node node;
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node deleteNode(Node root, int target) {
        if (root == null)
            return null;
        if (root.data > target) // go left
            root.left = deleteNode(root.left, target);
        else if (root.data < target) // go right
            root.right = deleteNode(root.right, target);
        else { // root.data == target
               // Case 1 (Leaf Node)
            if (root.left == null && root.right == null)
                return null;
            // Case 2 (1 child node)
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            // Case 3 (2 Child Nodes)
            Node succ = root.right;
            while (succ.left != null)
                succ = succ.left;
            root.right = deleteNode(root.right, succ.data);
            succ.left = root.left;
            succ.right = root.right;
            return succ;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root value");
        int rootVal = sc.nextInt();
        Node root = new Node(rootVal);
        System.out.println("Enter left value");
        int leftVal = sc.nextInt();
        Node left = new Node(leftVal);
        System.out.println("Enter right value");
        int rightVal = sc.nextInt();
        Node right = new Node(rightVal);
        root.left = left;
        root.right = right;
        DeleteTreeNode dt = new DeleteTreeNode();
        dt.deleteNode(root, rootVal);
        System.out.println("Tree after deletion: " + root);
    }
}