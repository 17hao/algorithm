#include <iostream>
#include <stack>
#include <vector>

#include "../Tree.h"

using std::vector;

/**
 * inorder traversal of binary tree
 * iterate
 *
 * @since 2020-10-12 Monday 15:00 - 15:33
 */
class Solution {
   public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root != nullptr) {
            std::stack<TreeNode*> stack;
            stack.push(root);
            while (!stack.empty()) {
                while (root->left != nullptr) {
                    stack.push(root->left);
                    root = root->left;
                }
                TreeNode* cur = stack.top();
                stack.pop();
                if (cur->right != nullptr) {
                    root = cur->right;
                    stack.push(root);
                }
                res.push_back(cur->val);
            }
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    TreeNode* root = Tree::binaryTree();
    Solution s;
    vector<int> res = s.inorderTraversal(root);
    for (int i : res) {
        std::cout << i << " ";
    }
}
