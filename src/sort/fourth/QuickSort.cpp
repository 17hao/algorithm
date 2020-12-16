#include <iostream>
#include "../tool.h"

/**
 * quick sort
 *
 * @since 2020-12-16 Wednesday 11:18
 */
void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void partition(int* arr, int start, int end) {
    if (start >= end) { // small = start - 1会出现ebn小于start情况
        return;
    }
    int pivot = start + (end - start) / 2;
    swap(arr, pivot, end);
    int small = start - 1, big = end;
    int i = start;
    while (i < big) {
        if (arr[i] < arr[end]) {
            i++;
            small++;
        } else if (arr[i] == arr[end]) {
            i++;
        } else {
            swap(arr, i, --big);
        }
    }
    swap(arr, end, big);
    partition(arr, start, small);
    partition(arr, big + 1, end);
}

void sort(int* arr, int len) {
    partition(arr, 0, len - 1);
}

int main(int argc, const char* argv[]) {
    int arr[7] = {9, 8, 5, 1, 0, 2, 7};
    sort(arr, 7);
    printArr(arr, 7);
}
