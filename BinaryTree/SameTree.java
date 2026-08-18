package BinaryTree;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}

public class SameTree {
    class Solution {
    //     0      0        Not Same
    //    /        \
    //   0          0
    boolean isIdentical(Node p, Node q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.data != q.data) return false;
        return isIdentical(p.left,q.left) && isIdentical(p.right,q.right);
    }
}
}
