#include "Tree.h"

/*
     1
    / \
   2   13
  / \
 3   5
    / \
   4   6
*/
TreeNode* Tree::binaryTree() {
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(13);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(5);
    root->left->right->left = new TreeNode(4);
    root->left->right->right = new TreeNode(6);
    return root;
}