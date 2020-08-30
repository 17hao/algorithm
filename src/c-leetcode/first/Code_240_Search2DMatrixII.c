/* 
   @since 2020-8-29 Saturday 11:01 - 11:14
*/

#include <stdbool.h>
#include <stdio.h>

bool searchMatrix(int **matrix, int matrixRowSize, int matrixColSize, int target)
{
    if (matrixRowSize == 0 || matrixColSize == 0)
        return false;
    int i = 0, j = matrixColSize - 1;
    while (i <= matrixRowSize - 1 && j >= 0)
    {
        int num = matrix[i][j];
        if (num == target)
            return true;
        else if (num < target)
            i++;
        else
            j--;
    }
    return false;
}

int main(int argc, char const *argv[])
{
    int *arr[5] = {
        (int[]){1, 4, 7, 11, 15},
        (int[]){2, 5, 8, 12, 19},
        (int[]){3, 6, 9, 16, 22},
        (int[]){10, 13, 14, 17, 24},
        (int[]){18, 21, 23, 26, 30}};
    printf("%d\n", searchMatrix(arr, 5, 5, 5));
    printf("%d\n", searchMatrix(arr, 5, 5, 20));

    int *b[1] = {(int[]) {5}};
    printf("%d\n", searchMatrix(b, 1, 1, 5));
}
