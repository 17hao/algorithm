/* 
   @since 2020-8-30 Sunday 12:15
*/

#include <stdio.h>
#include "../TreeNode.h"

int helper(struct TreeNode *root);
int max(int i, int j);

int res = 0x80000000;

int maxPathSum(struct TreeNode *root)
{
    helper(root);
    return res;
}

/* 
   @return 子树能为最大路径贡献的值
*/
int helper(struct TreeNode *root)
{
    if (root == 0)
        return 0;
    int left = helper(root->left);
    int right = helper(root->right);
    res = max((left + right + root->val), res);
    return max(max(left, right) + root->val, 0);
}

int max(int i, int j)
{
    return i < j ? j : i;
}

int main(int argc, char const *argv[])
{
    struct TreeNode *root = binaryTree();
    int res = maxPathSum(root); // 11
    printf("%d\n", res);
}