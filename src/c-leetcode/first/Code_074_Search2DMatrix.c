/* 
    matrix = [
     ⁠ [1,   3,  5,  7],
     ⁠ [10, 11, 16, 20],
     ⁠ [23, 30, 34, 50]
     ]
   @since 2020-8-29 Saturday 10:21 - 10:40
*/

#include <stdbool.h>
#include <stdio.h>

bool searchMatrix(int **matrix, int matrixSize, int *matrixColSize, int target)
{
    if (matrixSize == 0 || matrixColSize[0] == 0)
        return false;
    int col = matrixSize;
    for (int i = 0; i < matrixSize; i++)
    {
        if (target <= matrix[i][matrixColSize[0] - 1])
        {
            col = i;
            break;
        }
    }
    printf("col: %d\n", col);
    if (col == matrixSize)
        return false;
    int min = 0, max = matrixColSize[0] - 1;
    while (min <= max)
    {
        int mid = min + (max - min) / 2;
        if (matrix[col][mid] == target)
            return true;
        else if (matrix[col][mid] < target)
            min = mid + 1;
        else
            max = mid - 1;
    }
    return false;
}

int main(int argc, char const *argv[])
{
    int *matrix[4] = {(int[]){1, 3, 5, 7}, (int[]){10, 11, 16, 20}, (int[]){23, 30, 34, 50}};
    int arr[3] = {4, 4, 4};
    printf("%d\n", searchMatrix(matrix, 3, arr, 3));
    printf("%d\n", searchMatrix(matrix, 3, arr, 4));
}
