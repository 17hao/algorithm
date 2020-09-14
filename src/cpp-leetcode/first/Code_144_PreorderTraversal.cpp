#include <iostream>
#include <stack>
#include <vector>

#include "../Tree.h"

/**
 * binary tree preorder traversal
 *
 * @since 2020-9-14 Monday 14:43 - 14:50
 */
class Solution {
   public:
    std::vector<int> preorderTraversal(TreeNode* root) {
        if (root == NULL)
            return {};
        std::vector<int> res;
        std::stack<TreeNode*> stack;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode* cur = stack.top();
            stack.pop();
            res.push_back(cur->val);
            if (cur->right != NULL) {
                stack.push(cur->right);
            }
            if (cur->left != NULL) {
                stack.push(cur->left);
            }
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    TreeNode* root = Tree::binaryTree();
    Solution s;
    std::vector<int> res = s.preorderTraversal(root);
    for (int i : res) {
        std::cout << i << std::endl;
    }
}
