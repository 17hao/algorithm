#include "Tree.h"

/*
     1
    / \
   2   7
  / \
 4   5
*/
TreeNode* Tree::binaryTree() {
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(7);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    return root;
}