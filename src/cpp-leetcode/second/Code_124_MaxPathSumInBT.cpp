#include <algorithm>
#include <iostream>

#include "../Tree.h"

/**
 * max path in bianry tree
 *
 * @since 2020-11-18 Wednesday
 */
class Solution {
    int res;

    /** 返回当前根节点能为最大路径贡献的路径长度 */
    int helper(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int left = std::max(helper(root->left), 0);
        int right = std::max(helper(root->right), 0);
        res = std::max(res, std::max(root->val, root->val + left + right));
        return std::max(root->val, std::max(root->val + left, root->val + right));
    }

   public:
    int maxPathSum(TreeNode* root) {
        res = root->val;
        helper(root);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    TreeNode* root = Tree::binaryTree();
    Solution s;
    std::cout << s.maxPathSum(root) << "\n";
}
