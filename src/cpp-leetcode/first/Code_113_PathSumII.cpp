#include <iostream>
#include <vector>

#include "../Tree.h"

using std::vector;

/**
 * Finding all root-to-leaf paths where path's sum equals the given sum
 *
 * @since 2020-9-20 Sunday 22:00 - 23:00
 */
class Solution {
   private:
    vector<vector<int>> res;

    /* pass by value */
    void dfs(TreeNode* root, int sum, vector<int> tmp) {
        if (root == nullptr)
            return;
        if (sum - root->val == 0 && root->left == nullptr && root->right == nullptr) {
            tmp.push_back(root->val);
            res.push_back(tmp);
            return;
        }
        tmp.push_back(root->val);
        dfs(root->left, sum - root->val, tmp);
        dfs(root->right, sum - root->val, tmp);
        tmp.pop_back();
    }

    /* pass by reference(faster) */
    void _dfs(TreeNode* root, int sum, vector<int>& tmp) {
        if (root == nullptr)
            return;
        if (root->left == nullptr && root->right == nullptr) {
            if (sum - root->val == 0) {
                tmp.push_back(root->val);
                res.push_back(tmp);
                return;
            } else {
                tmp.push_back(root->val);
                return;
            }
        }
        tmp.push_back(root->val);
        dfs(root->left, sum - root->val, tmp);
        if (root->left != nullptr) {
            tmp.pop_back();
        }
        dfs(root->right, sum - root->val, tmp);
        if (root->right != nullptr) {
            tmp.pop_back();
        }
    }

   public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> tmp;
        dfs(root, sum, tmp);
        return res;
    }
};

int main() {
    Solution s;
    TreeNode* root = Tree::binaryTree();
    vector<vector<int>> res = s.pathSum(root, 8);
    std::cout << "\nres:\n";
    for (auto v : res) {
        for (int i : v) {
            std::cout << i << ", ";
        }
        std::cout << std::endl;
    }
}