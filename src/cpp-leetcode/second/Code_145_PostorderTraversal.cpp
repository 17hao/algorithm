#include <iostream>
#include <vector>
#include <stack>

#include "../Tree.h"

using std::vector;

/**
 * postorder traversal of binary tree
 * iterate
 *
 * @since 2020-10-10 Saturday 15:43
 */
class Solution {
    void dfs(TreeNode* root, vector<int>& res) {
        if (root == nullptr) {
            return;
        }
        dfs(root->right, res);
        dfs(root->left, res);
        res.push_back(root->val);
    }

   public:
    vector<int> _postorderTraversal(TreeNode* root) {
        vector<int> res;
        dfs(root, res);
        return res;
    }

    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root != nullptr) {
            std::stack<TreeNode*> s1, s2;
            s1.push(root);
            while (!s1.empty()) {
                TreeNode* cur = s1.top();
                s1.pop();
                s2.push(cur);
                if (cur->right != nullptr) {
                    s1.push(cur->right);
                }
                if (cur->left != nullptr) {
                    s1.push(cur->left);
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
