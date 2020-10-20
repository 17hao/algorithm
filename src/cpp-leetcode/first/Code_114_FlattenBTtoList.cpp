#include <iostream>

#include "../Tree.h"

/**
 * flatten binary tree to list
 *
 * @since 2020-10-20 Tuesday 10:28
 */
class Solution {
   public:
    void flatten(TreeNode* root) {
        if (root == nullptr) {
            return;
        } else {
            TreeNode* right = root->right;
            flatten(right);
            root->right = root->left;
            root->left = nullptr;
            while (root->right != nullptr) {
                root = root->right;
                flatten(root);
            }
            root->right = right;
        }
    }

    void _flatten(TreeNode* root) {
        if (root == nullptr) {
            return;
        } else {
            TreeNode* right = root->right;
            root->right = root->left;
            root->left = nullptr;
            TreeNode* node = root;
            while (node->right != nullptr) {
                node = node->right;
            }
            node->right = right;
            _flatten(root->right);
        }
    }

    void __flatten(TreeNode* root) {
        while (root != nullptr) {
            if (root->left == nullptr) {
                root = root->right;
            } else {
                TreeNode* pre = root->left;
                while (pre->right != nullptr) {
                    pre = pre->right;
                }
                pre->right = root->right;
                root->right = root->left;
                root->left = nullptr;
                root = root->right;
            }
        }
    }
};

int main(int argc, char const* argv[]) {
    TreeNode* root = Tree::binaryTree();
    Solution s;
    // s.flatten(root);
    // s._flatten(root);
    s.__flatten(root);
    while (root != nullptr) {
        std::cout << root->val << "->";
        root = root->right;
    }
}