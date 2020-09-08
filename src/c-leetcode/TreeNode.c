#include <stdlib.h>
#include "TreeNode.h"

/* 
        1
       / \
      2   7
     / \
    4   5
*/
TreeNode *binaryTree()
{
    TreeNode *root, *n1, *n2, *n3, *n4;
    root = malloc(sizeof(TreeNode));
    n1 = malloc(sizeof(TreeNode));
    n2 = malloc(sizeof(TreeNode));
    n3 = malloc(sizeof(TreeNode));
    n4 = malloc(sizeof(TreeNode));
    root->val = 1;
    n1->val = 2;
    n2->val = 7;
    n3->val = 4;
    n4->val = 5;
    root->left = n1;
    root->right = n2;
    n1->left = n3;
    n1->right = n4;
    return root;
}

TreeNode *binarySearchTree()
{
    TreeNode *root, *n1, *n2, *n3, *n4, *n5;
    root = malloc(sizeof(TreeNode));
    n1 = malloc(sizeof(TreeNode));
    n2 = malloc(sizeof(TreeNode));
    n3 = malloc(sizeof(TreeNode));
    n4 = malloc(sizeof(TreeNode));
    n5 = malloc(sizeof(TreeNode));
    root->val = 5;
    n1->val = 3;
    n2->val = 6;
    n3->val = 2;
    n4->val = 4;
    n5->val = 1;
    root->left = n1;
    root->right = n2;
    n1->left = n3;
    n1->right = n4;
    n3->left = n5;
    return root;
}

TreeNode *_binarySearchTree()
{
    TreeNode *root, *n1, *n2, *n3;
    root = malloc(sizeof(TreeNode));
    n1 = malloc(sizeof(TreeNode));
    n2 = malloc(sizeof(TreeNode));
    n3 = malloc(sizeof(TreeNode));
    root->val = 3;
    n1->val = 1;
    n2->val = 4;
    n3->val = 2;
    root->left = n1;
    root->right = n2;
    n1->right = n3;
    return root;
}