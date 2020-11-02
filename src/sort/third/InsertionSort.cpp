#include <iostream>

#include "../tool.h"

void swap(int* arr, int i, int j);

/**
 * insertion sort
 *
 * @since 2020-11-2 Monday 19:35
 */
void sort(int* arr, int len) {
    for (int i = 1; i < len; i++) {
        for (int j = i; j > 0; j--) {
            if (arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
            }
        }
    }
}

void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

int main(int argc, char const* argv[]) {
    int arr[7] = {4, 2, 1, 5, 1, 9, 10};
    sort(arr, 7);
    printArr(arr, 7);
}
