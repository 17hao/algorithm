#include <algorithm>

#include "../Tree.h"

/**
 * diameter of binary tree
 * 
 * @since 2020-9-19 Saturday 23:30 - 23:36'
 */
class Solution {
   private:
    int res = 0;

    int dfs(TreeNode* node) {
        if (node == nullptr) {
            return 0;
        }
        int left = dfs(node->left);
        int right = dfs(node->right);
        res = std::max(res, left + right + 1);
        return std::max(left, right) + 1;
    }

   public:
    int diameterOfBinaryTree(TreeNode* root) {
        if (root == 0) {
            return 0;
        }
        dfs(root);
        return res - 1;
    }
};