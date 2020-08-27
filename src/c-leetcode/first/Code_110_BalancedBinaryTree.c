/* balanced binary tree

   gcc Code_110_BalancedBinaryTree.c ../TreeNode.c
   
   @since 2020-8-27 Thursday 11:12 - 11:33
 */

#include "../TreeNode.h"
#include <stdio.h>
#include <stdbool.h>

int max(int i, int j);
int abs(int i);
int maxDepth(struct TreeNode *root);

bool isBalanced(struct TreeNode *root)
{
    if (root == 0)
        return true;
    if (abs(maxDepth(root->left) - maxDepth(root->right)) > 1)
        return false;
    else
        return isBalanced(root->left) && isBalanced(root->right);
}

int maxDepth(struct TreeNode *root)
{
    if (root == 0)
        return 1;
    else
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
}

int max(int i, int j)
{
    return i < j ? j : i;
}

int abs(int i)
{
    return i > 0 ? i : -i;
}

int main(int argc, char const *argv[])
{
    bool res = isBalanced(binaryTree());
    printf("%d\n", res);
}
