#include <iostream>

#include "../tool.h"

/**
 * shell sort
 * 希尔排序是插入排序的改良版，所以抓住插入排序的特点，也就是向前寻找当前元素正确的位置。
 *
 * @since 2020-11-1 Sunday 12:01
 */
void shellSort(int* arr, int len) {
    for (int gap = len / 2; gap >= 1; gap /= 2) {
        for (int i = gap; i < len; i++) {
            int temp = arr[i];
            int j = i;
            for (; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;
        }
    }
}

int main(int argc, char const* argv[]) {
    int arr[7] = {7, 8, 1, 5, 1, 0, 10};
    // int arr[7] = {7, 6, 5, 4, 3, 2, 1};
    shellSort(arr, 7);
    printArr(arr, 7);
}
