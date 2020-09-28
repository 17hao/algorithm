#include <iostream>
#include <vector>

#include "../Tree.h"

using std::vector;

/**
 * path sum 2
 *
 * @since 2020-9-28 Monday 10:48 - 10:55
 */
class Solution {
    void dfs(TreeNode* root, int sum, vector<int> tmp, vector<vector<int>>& res) {
        if (root == nullptr) {
            return;
        }
        if (root->left == nullptr && root->right == nullptr && sum - root->val == 0) {
            tmp.push_back(root->val);
            res.push_back(tmp);
            return;
        }
        tmp.push_back(root->val);
        dfs(root->left, sum - root->val, tmp, res);
        dfs(root->right, sum - root->val, tmp, res);
    }

   public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> tmp;
        vector<vector<int>> res;
        dfs(root, sum, tmp, res);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    TreeNode* root = Tree::binaryTree();
    vector<vector<int>> res = s.pathSum(root, 14);
    for (auto x : res) {
        for (int i : x) {
            std::cout << i << " ";
        }
        std::cout << "\n";
    }
}
