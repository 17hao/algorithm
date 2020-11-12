#include "../tool.h"

/**
 * insertion sort
 *
 * @since 2020-11-12 Thursday
 */
void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void insertionSort(int* arr, int len) {
    for (int i = 1; i < len; i++) {
        for (int j = i; j > 0; j--) {
            if (arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
            }
        }
    }
}

int main(int argc, char const* argv[]) {
    int arr[7] = {4, 5, 1, 2, 4, 1, 0};
    insertionSort(arr, 7);
    printArr(arr, 7);
}
