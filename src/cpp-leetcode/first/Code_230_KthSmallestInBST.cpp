#include <iostream>

#include "../Tree.h"

/**
 * kth smallest in binary search tree
 *
 * @since 2020-9-29 Tuesday 14:25 - 14:47
 */
class Solution {
    int res, cur;

    void dfs(TreeNode* root, int k) {
        if (root == nullptr) {
            return;
        }
        dfs(root->left, k);
        cur++;
        if (cur == k) {
            res = root->val;
            return;
        }
        dfs(root->right, k);
    }

   public:
    int kthSmallest(TreeNode* root, int k) {
        dfs(root, k);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    TreeNode* root = Tree::binaryTree();
    int res = s.kthSmallest(root, 6);
    std::cout << res << std::endl;
}
