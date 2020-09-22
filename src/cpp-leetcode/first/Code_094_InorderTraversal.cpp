#include <iostream>
#include <stack>
#include <vector>

#include "../Tree.h"
using std::vector;

/**
 * inorder traversal of binary tree
 * iterate
 *
 * @since 2020-9-22 Tuesday 10:34 - 10:51
 */
class Solution {
   public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root != nullptr) {
            std::stack<TreeNode*> stack;
            stack.push(root);
            root = root->left;
            while (!stack.empty()) {
                while (root != nullptr) {
                    stack.push(root);
                    root = root->left;
                }
                TreeNode* node = stack.top();
                stack.pop();
                res.push_back(node->val);
                if (node->right != nullptr) {
                    root = node->right;
                    stack.push(root);
                    root = root->left;
                }
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
