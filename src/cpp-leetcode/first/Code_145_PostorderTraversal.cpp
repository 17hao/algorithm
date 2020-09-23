#include <iostream>
#include <stack>
#include <vector>

#include "../Tree.h"

using std::vector;

/**
 * postorder traversal of binary tree
 *
 * @since 2020-9-22 Wednesday 17:16 - 17:34
 */
class Solution {
   public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root != nullptr) {
            std::stack<TreeNode*> s1;
            std::stack<TreeNode*> s2;
            s1.push(root);
            while (!s1.empty()) {
                TreeNode* cur = s1.top();
                s1.pop();
                s2.push(cur);
                if (cur->left != nullptr) {
                    s1.push(cur->left);
                }
                if (cur->right != nullptr) {
                    s1.push(cur->right);
                }
            }
            while (!s2.empty()) {
                res.push_back(s2.top()->val);
                s2.pop();
            }
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    TreeNode* root = Tree::binaryTree();
    Solution s;
    vector<int> res = s.postorderTraversal(root);
    for (int i : res) {
        std::cout << i << " ";
    }
}
