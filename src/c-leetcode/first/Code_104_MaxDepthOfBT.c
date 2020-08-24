#include "../TreeNode.h"
#include "../TreeNode.c"
#include <stdio.h>

/**
 * 二叉树最大深度
 * 
 * @since 2020-8-20 Thursday 19:07
 */
int max(int i, int j);

int maxDepth(struct TreeNode *root)
{
    if (root == NULL)
        return 0;
    return max(maxDepth(root->left), maxDepth(root->right)) + 1;
}

int max(int i, int j)
{
    return i > j ? i : j;
}

int main(int argc, char *argv[])
{
    printf("%d\n", maxDepth(binaryTree()));
    printf("%d\n", maxDepth(binarySearchTree()));
}