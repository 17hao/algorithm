#include <iostream>
#include <stack>
#include <vector>
#include "../Tree.h"

/**
 * preorder traversal of binary tree
 *
 * @since 2020-12-17 Thursday 22:50
 */
class Solution {
    void recursiveHelper(TreeNode* root, std::vector<int>& res) {
        if (root == nullptr) {
            return;
        }
        res.push_back(root->val);
        recursiveHelper(root->left, res);
        recursiveHelper(root->right, res);
    }

public:
    std::vector<int> preorderTraversalRecursively(TreeNode* root) {
        std::vector<int> v;
        recursiveHelper(root, v);
        return v;
    }

	std::vector<int> preorderTraversalIteratively(TreeNode* root) {
		std::vector<int> res;
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

int main(int argc, const char* argv[]) {
    TreeNode* root = Tree::binarySearchTree();
    Solution s;
    std::vector<int> res1 = s.preorderTraversalRecursively(root);
    std::vector<int> res2 = s.preorderTraversalIteratively(root);
    std::cout << "recursive res: ";
    for(int i : res1) {
        std::cout << i << " ";
    }
	std::cout << "\n===\n";
	std::cout << "iterative res: ";
	for (int i : res2) {
		std::cout << i << " ";
	}
}
