/* sum root to leaf number

   @since 2020-9-9 Wednesday
*/

#include <stdio.h>
#include "../TreeNode.h"

void dfs(struct TreeNode *root, int num, int *res)
{
    if (root == 0)
        return;
    if (root->left == 0 && root->right == 0)
    {
        num = num * 10 + root->val;
        *res += num;
        printf("num: %d\n", num);
        return;
    }
    num = num * 10 + root->val;
    dfs(root->left, num, res);
    dfs(root->right, num, res);
}

int sumNumbers(struct TreeNode *root)
{
    int res = 0;
    if (root == 0)
        return res;
    dfs(root, 0, &res);
    return res;
}


int main(int argc, char const *argv[])
{
    struct TreeNode *root = binaryTree();
    int res = sumNumbers(root);
    printf("%d ", res);
}
