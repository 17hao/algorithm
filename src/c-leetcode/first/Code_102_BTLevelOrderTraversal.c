/* binary tree level order

   @since 2020-9-8 Tuesday 17:43
   @update 2020-9-9 Wednesday 17:22
*/

#include "../TreeNode.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int **res;

void dfs(struct TreeNode *root, int level, int *returnSize, int **returnColSizes)
{
    if (root == 0)
        return;
    // if (!res[level])
    if (!returnColSizes[0][level])
    {
        res[level] = malloc(1024 * sizeof(int));
        *returnSize += 1;
    }
    int arrLen = returnColSizes[0][level];
    printf("root: %d level: %d arrLen: %d\n", root->val, level, arrLen);
    res[level][arrLen++] = root->val;
    returnColSizes[0][level++] = arrLen;
    dfs(root->left, level, returnSize, returnColSizes);
    dfs(root->right, level, returnSize, returnColSizes);
}

int **levelOrder(struct TreeNode *root, int *returnSize, int **returnColumnSizes)
{
    res = malloc(1024 * sizeof(int *));
    *returnColumnSizes = malloc(1024 * sizeof(int));
    memset(returnColumnSizes[0], 0, 1024 * sizeof(int));
    if (res == 0 || returnColumnSizes == 0)
        exit(-1);
    *returnSize = 0;
    if (root == 0)
        return res;
    int *arr = malloc(1024 * sizeof(int));
    dfs(root, 0, returnSize, returnColumnSizes);
    printf("returnSize: %d\n", *returnSize);
    printf("returnColSizes:");
    for (int i = 0; i < *returnSize; i++)
        printf("%d ", returnColumnSizes[0][i]);
    return res;
}

int main(int argc, char const *argv[])
{
    // struct TreeNode *root;
    struct TreeNode *root = binarySearchTree();
    int rs = 0;
    int *returnSize = &rs;
    int **returnColumnSizes = malloc(1024 * sizeof(int));
    int **res = levelOrder(root, returnSize, returnColumnSizes);
    printf("main returnSize: %d\n", *returnSize);
    printf("\n[\n");
    for (int i = 0; i < *returnSize; i++)
    {
        printf("[");
        for (int j = 0; j < returnColumnSizes[0][i]; j++)
            printf(" %d ", res[i][j]);
        printf("]\n");
    }
    printf("]\n");
}
