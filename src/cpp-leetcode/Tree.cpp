#include "Tree.h"

/*
     6
    / \
   2   13
  / \
 1   4
    / \
   3   5
*/
TreeNode* Tree::binarySearchTree() {
    TreeNode* root = new TreeNode(6);
    root->left = new TreeNode(2);
    root->right = new TreeNode(13);
    root->left->left = new TreeNode(1);
    root->left->right = new TreeNode(4);
    root->left->right->left = new TreeNode(3);
    root->left->right->right = new TreeNode(5);
    return root;
}
