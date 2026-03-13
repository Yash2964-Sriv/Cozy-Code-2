/**
 * Basic DSA - Path Sum (LeetCode 112)
 * Check if root-to-leaf path has target sum.
 */
#include <iostream>

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

bool hasPathSum(TreeNode* root, int targetSum) {
    if (!root) return false;
    if (!root->left && !root->right) return root->val == targetSum;
    int rem = targetSum - root->val;
    return hasPathSum(root->left, rem) || hasPathSum(root->right, rem);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Path Sum\n";
    std::cout << std::string(60, '=') << "\n";

    TreeNode* a = new TreeNode(5);
    a->left = new TreeNode(4);
    a->right = new TreeNode(8);
    a->left->left = new TreeNode(11);
    a->left->left->left = new TreeNode(7);
    a->left->left->right = new TreeNode(2);
    a->right->left = new TreeNode(13);
    a->right->right = new TreeNode(4);
    a->right->right->right = new TreeNode(1);
    std::cout << "[5,4,8,11,null,13,4,7,2,null,null,null,1], 22 -> "
              << (hasPathSum(a, 22) ? "true" : "false") << "\n";

    TreeNode* b = new TreeNode(1);
    b->left = new TreeNode(2);
    b->right = new TreeNode(3);
    std::cout << "[1,2,3], 5 -> " << (hasPathSum(b, 5) ? "true" : "false") << "\n";

    std::cout << "[], 0 -> " << (hasPathSum(nullptr, 0) ? "true" : "false") << "\n";
}