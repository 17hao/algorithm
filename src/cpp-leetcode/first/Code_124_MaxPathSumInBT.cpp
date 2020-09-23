#include <algorithm>
#include <iostream>
#include <vector>

#include "../Tree.h"

using std::vector;

/**
 * max path sum in a binary tree
 *
 * @since 2020-9-23 Wednesday 13:03
 */
class Solution {
    //    private:
    //     int res = 0;

    //     int dfs(TreeNode* root) {
    //         if (root == 0) {
    //             return 0;
    //         }
    //         int left = dfs(root->left);
    //         int right = dfs(root->right);
    //         int r = root->val;
    //         if (left > 0)
    //             r += left;
    //         if (right > 0)
    //             r += right;
    //         res = std::max(res, r);
    //         return std::max(root->val, root->val + std::max(left, right));
    //     }

    //    public:
    //     int maxPathSum(TreeNode* root) {
    //         if (root == nullptr) {
    //             return 0;
    //         }
    //         res = root->val;
    //         dfs(root);
    //         return res;
    //     }
   private:
    int res = 0x80000000;

    int dfs(TreeNode* root) {
        if (root == 0) {
            return 0;
        }
        int left = dfs(root->left);
        int right = dfs(root->right);
        res = std::max(res, root->val + left + right);
        return std::max(0, root->val + std::max(left, right));
    }

   public:
    int maxPathSum(TreeNode* root) {
        dfs(root);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    TreeNode* root = Tree::binaryTree();
    Solution s;
    std::cout << s.maxPathSum(root);
}
