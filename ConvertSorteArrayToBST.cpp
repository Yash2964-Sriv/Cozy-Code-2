/**
 * Basic DSA - Convert Sorted Array to BST (LeetCode 108)
 * Build height-balanced BST from sorted array.
 */
#include <iostream>
#include <vector>

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

TreeNode* sortedArrayToBST(std::vector<int>& nums, int lo, int hi) {
    if (lo > hi) return nullptr;
    int mid = lo + (hi - lo) / 2;
    TreeNode* root = new TreeNode(nums[mid]);
    root->left = sortedArrayToBST(nums, lo, mid - 1);
    root->right = sortedArrayToBST(nums, mid + 1, hi);
    return root;
}

TreeNode* sortedArrayToBST(std::vector<int>& nums) {
    return sortedArrayToBST(nums, 0, (int)nums.size() - 1);
}

void inorder(TreeNode* n) {
    if (!n) return;
    inorder(n->left);
    std::cout << n->val << " ";
    inorder(n->right);
}

int main() {
    std::cout << std::string(60, '=') << "\n";
    std::cout << "Problem: Convert Sorted Array to BST\n";
    std::cout << std::string(60, '=') << "\n";

    std::vector<int> a1 = {-10, -3, 0, 5, 9};
    TreeNode* r1 = sortedArrayToBST(a1);
    std::cout << "[-10,-3,0,5,9] inorder -> ";
    inorder(r1);
    std::cout << "\n";

    std::vector<int> a2 = {1, 3};
    TreeNode* r2 = sortedArrayToBST(a2);
    std::cout << "[1,3] inorder -> ";
    inorder(r2);
    std::cout << "\n";
}