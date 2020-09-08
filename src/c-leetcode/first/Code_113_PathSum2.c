/* 
   @since 2020-9-4 Friday
   @update 2020-9-7 Monday
   @finished 2020-9-8 Tuesday
 */

#include <stdio.h>
#include <stdlib.h>
#include "../TreeNode.h"

void dfs(struct TreeNode *root, int sum, int *tmp, int index, int *returnSize, int **returnColSizes, int **res)
{
    if (root == 0)
        return;
    if (root->left == 0 && root->right == 0 && sum - root->val == 0)
    {
        tmp[index++] = root->val;
        res[*returnSize] = malloc(index * sizeof(int));
        for (int i = 0; i < index; i++)
            res[*returnSize][i] = tmp[i];
        returnColSizes[0][*returnSize] = index;
        *returnSize += 1;
        return;
    }
    tmp[index++] = root->val;
    dfs(root->left, sum - root->val, tmp, index, returnSize, returnColSizes, res);
    dfs(root->right, sum - root->val, tmp, index, returnSize, returnColSizes, res);
}

int **pathSum(struct TreeNode *root, int sum, int *returnSize, int **returnColumnSizes)
{
    int **res = malloc(1024 * sizeof(int *));
    *returnColumnSizes = malloc(1024 * sizeof(int));
    if (res == 0 || returnColumnSizes == 0)
        exit(-1);
    *returnSize = 0;
    if (root == 0)
        return res;
    int *arr = malloc(1024 * sizeof(int));
    dfs(root, sum, arr, 0, returnSize, returnColumnSizes, res);
    printf("returnSize: %d\n", *returnSize);
    return res;
}

int main(int argc, char const *argv[])
{
    struct TreeNode *root = binaryTree();
    root->val = 1;
    int returnSize = 0;
    int **returnColumnSizes = malloc(100 * sizeof(int *));
    int **res = pathSum(root, 8, &returnSize, returnColumnSizes);
    printf("[\n");
    for (int i = 0; i < returnSize; i++)
    {
        printf(" [ ");
        for (int j = 0; j < returnColumnSizes[0][i]; j++)
            printf("%d ", res[i][j]);
        printf("]\n");
    }
    printf("]\n");
}
