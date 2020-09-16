#include <cstdbool>
#include <iostream>

#include "../Tree.h"

class Solution {
   private:
    TreeNode* res;

    /*
        return true if (root == p || q) || root's left tree contains p || q
     */
    bool dfs(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr) {
            return false;
        }
        bool left = dfs(root->left, p, q);
        bool right = dfs(root->right, p, q);
        bool mid = root == p || root == q;
        if ((mid && (left || right)) || (left && right)) {
            res = root;
        }
        return mid || left || right;
    }

   public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == nullptr) {
            return nullptr;
        }
        dfs(root, p, q);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    TreeNode* root = new TreeNode(1);
    TreeNode* p = new TreeNode(2);
    TreeNode* q = new TreeNode(3);
    root->left = p;
    root->right = q;
    Solution s;
    TreeNode* res = s.lowestCommonAncestor(root, p, q);
    std::cout << res->val << std::endl;
}
