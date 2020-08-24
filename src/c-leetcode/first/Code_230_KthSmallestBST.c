#include "../TreeNode.h"
#include "../TreeNode.c"
#include <stdio.h>

/* Kth smallest in BST
   
   @sicne 2020-8-24 Monday
 */
void helper(struct TreeNode *root, int k);
int res;
int count;

int kthSmallest(struct TreeNode *root, int k)
{
    if (root == 0)
        return 0;
    count = 0;
    helper(root, k);
    return res;
}

void helper(struct TreeNode *root, int k)
{
    if (root == 0)
        return;
    else
    {
        helper(root->left, k);
        if (++count == k)
            res = root->val;
        helper(root->right, k);
    }
}

int main()
{
    printf("%d\n", kthSmallest(binarySearchTree(), 1));
    printf("%d\n", kthSmallest(binarySearchTree(), 3));
    printf("%d\n", kthSmallest(binarySearchTree(), 5));
    printf("%d\n", kthSmallest(binarySearchTree(), 6));
}