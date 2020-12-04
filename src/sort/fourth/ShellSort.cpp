#include <iostream>

#include "../tool.h"

/**
 * shell sort
 *
 * @since 2020-12-4 Friday 17:52
 */
void sort(int* arr, int len) {
    for (int gap = len / 2; gap >= 1; gap /= 2) {
        for (int i = gap; i < len; i++) {
            int temp = arr[i];
            int j = i;
            for (; j - gap >= 0 && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;
        }
    }
}

int main(int argc, char const* argv[]) {
    int arr[7] = {7, 1, 2, 10, 12, 0, 99};
    sort(arr, 7);
    printArr(arr, 7);
}
