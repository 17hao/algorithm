#include <iostream>
#include <vector>

#include "../Tree.h"

using std::vector;

/**
 * binary tree level order traversal
 *
 * @since 2020-11-2 Monday 19:50 - 20:00
 */
class Solution {
    void bfs(TreeNode* root, vector<vector<int>>& res, int level) {
        if (root == nullptr) {
            return;
        }
        if (level == res.size()) {
            res.push_back({});
        }
        vector<int>& v = res[level];
        v.push_back(root->val);
        bfs(root->left, res, level + 1);
        bfs(root->right, res, level + 1);
    }

   public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        bfs(root, res, 0);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    TreeNode* root = Tree::binaryTree();
    vector<vector<int>> res = s.levelOrder(root);
    for (auto v : res) {
        std::cout << "[";
        for (int i : v) {
            std::cout << i << " ";
        }
        std::cout << "]\n";
    }
}
