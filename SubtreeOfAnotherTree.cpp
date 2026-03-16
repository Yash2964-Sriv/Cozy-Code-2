/**
 * Basic DSA - Subtree of Another Tree (LeetCode 572)
 * Check if subRoot is subtree of root.
 */
#include <iostream>

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

bool isSame(TreeNode* p, TreeNode* q) {
    if (!p && !q) return true;
    if (!p || !q) return false;
    return p->val == q->val && isSame(p->left, q->left) && isSame(p->right, q->right);
}

bool isSubtree(TreeNode* root, TreeNode* subRoot) {
    if (!root) return !subRoot;
    if (isSame(root, subRoot)) return true;
    return isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Subtree of Another Tree\n";
    std::cout << std::string(60, '=') << "\n";

    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(4);
    root->right = new TreeNode(5);
    root->left->left = new TreeNode(1);
    root->left->right = new TreeNode(2);
    TreeNode* sub = new TreeNode(4);
    sub->left = new TreeNode(1);
    sub->right = new TreeNode(2);
    std::cout << "[3,4,5,1,2], [4,1,2] -> " << (isSubtree(root, sub) ? "true" : "false") << "\n";

    TreeNode* r2 = new TreeNode(3);
    r2->left = new TreeNode(4);
    r2->right = new TreeNode(5);
    r2->left->left = new TreeNode(1);
    r2->left->right = new TreeNode(2);
    r2->left->right->left = new TreeNode(0);
    TreeNode* sub2 = new TreeNode(4);
    sub2->left = new TreeNode(1);
    sub2->right = new TreeNode(2);
    std::cout << "[3,4,5,1,2,null,null,0], [4,1,2] -> " << (isSubtree(r2, sub2) ? "true" : "false") << "\n";
}