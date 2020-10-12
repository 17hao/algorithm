#include <iostream>
#include <stack>
#include <vector>

#include "../Tree.h"

using std::vector;

/**
 * preorder traversal of binary tree
 * iterate
 *
 * @since 2020-10-12 Monday 16:50
 */
class Solution {
   public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root != nullptr) {
            std::stack<TreeNode*> stack;
            stack.push(root);
            while (!stack.empty()) {
                TreeNode* cur = stack.top();
                stack.pop();
                res.push_back(cur->val);
                if (cur->right != nullptr) {
                    stack.push(cur->right);
                }
                if (cur->left != nullptr) {
                    stack.push(cur->left);
                }
            }
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    TreeNode* root = Tree::binaryTree();
    Solution s;
    vector<int> res = s.preorderTraversal(root);
    for (int i : res) {
        std::cout << i << " ";
    }
}
