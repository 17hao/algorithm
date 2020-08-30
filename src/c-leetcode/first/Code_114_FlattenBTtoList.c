/*
   @since 2020-8-30 Sunday 10:09 - 10:45
 */

#include <stdio.h>
#include "../TreeNode.h"

struct TreeNnode *helper(struct TreeNode *root);

void _flatten(struct TreeNode *root)
{
    if (root == 0)
        return;
    struct TreeNode *right = root->right;
    _flatten(right);
    root->right = root->left;
    root->left = 0;
    while (root->right != 0)
    {
        root = root->right;
        _flatten(root);
    }
    root->right = right;
}

void flatten(struct TreeNode *root)
{
    while (root != 0)
    {
        if (root->left == 0)
            root = root->right;
        else
        {
            struct TreeNode *pre = root->left;
            while (pre->right != 0)
                pre = pre->right;
            pre->right = root->right;
            root->right = root->left;
            root->left = 0;
            root = root->right;
        }
    }
}

int main(int argc, char const *argv[])
{
    struct TreeNode *root = binaryTree();
    _flatten(root);
    while (root != 0)
    {
        printf("%d ", root->val);
        root = root->right;
    }
    printf("\n");
}
