/* insertion sort

   It tries to divide the input list into 2 separable lists, the first list
   is sorted and the second one is not.
   Elements of the unsorted list is transferred and insrted into their proper
   position in sorted list.

   insertion sort does not change the relative order of elements with equal keys

   @since 2020-8-31 Monday 16:42
*/

#include <stdio.h>

#include "../tool.h"

void swap(int *arr, int i, int j);

void sort(int *arr, int size) {
    for (int i = 1; i < size; i++) {
        for (int j = i; j > 0; j--) {
            if (arr[j] < arr[j - 1])
                swap(arr, j, j - 1);
            else
                break;
        }
    }
}

void swap(int *arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

int main(int argc, char const *argv[]) {
    int arr[7] = {3, 1, 2, 4, 1, 2, 5};
    sort(arr, 7);
    printArr(arr, 7);
    printf("\n");

    /*
        worst performance
        O(n^2) comparisions
        0(n^2) swaps
    */
    int worst[7] = {7, 6, 5, 4, 3, 2, 1};  // worst performance
    sort(worst, 7);
    printArr(worst, 7);
    printf("\n");

    /*
        best performance
        O(n) comparisions
        O(1) swaps
    */
    int best[7] = {1, 2, 3, 4, 5, 6, 7};
    sort(best, 7);
    printArr(best, 7);
    printf("\n");
}