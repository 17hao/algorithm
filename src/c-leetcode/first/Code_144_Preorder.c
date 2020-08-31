/*
   @since 2020-8-31 Monday 11:27
 */

#include "../TreeNode.h"
#include <stdio.h>
#include <stdlib.h>

int *preorderTraversal(struct TreeNode *root, int *returnSize)
{
    int sp = -1;
    *returnSize = 0;
    struct TreeNode **stack = malloc(100 * sizeof(struct TreeNode *));
    if (!stack)
        return 0;
    int *res = malloc(100 * sizeof(int));
    if (root != 0)
        stack[++sp] = root;
    while (sp >= 0)
    {
        struct TreeNode *node = stack[sp--];
        res[(*returnSize)++] = node->val;
        if (node->right != 0)
            stack[++sp] = node->right;
        if (node->left != 0)
            stack[++sp] = node->left;
    }
    return res;
}

int main(int argc, char const *argv[])
{
    TreeNode *root = binaryTree();
    int size = 5;
    int *res = preorderTraversal(root, &size);
    for (int i = 0; i < 5; i++)
        printf("%d ", res[i]);
}
