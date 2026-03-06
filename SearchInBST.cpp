/**
 * Basic DSA - Search in a Binary Search Tree (LeetCode 700)
 * Find node with val equal to target in BST.
 */
#include <iostream>

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode* searchBST(TreeNode* root, int val) {
    if (!root || root->val == val) return root;
    return val < root->val ? searchBST(root->left, val) : searchBST(root->right, val);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Search in a Binary Search Tree\n";
    std::cout << std::string(60, '=') << "\n";

    TreeNode* root = new TreeNode(4);
    root->left = new TreeNode(2);
    root->right = new TreeNode(7);
    root->left->left = new TreeNode(1);
    root->left->right = new TreeNode(3);
    TreeNode* r1 = searchBST(root, 2);
    std::cout << "[4,2,7,1,3], val=2 -> " << (r1 ? r1->val : -1) << "\n";

    TreeNode* r2 = searchBST(root, 5);
    std::cout << "[4,2,7,1,3], val=5 -> " << (r2 ? r2->val : -1) << "\n";
}