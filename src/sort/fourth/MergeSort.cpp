#include <iostream>

#include "../tool.h"

/**
 * merge sort
 *
 * @since 2020-11-11 Wednesday 16:34
 */
void merge(int* arr, int start, int mid, int end) {
    int l1 = mid - start + 1, l2 = end - mid;
    int left[l1], right[l2];
    for (int i = 0; i < l1; i++) {
        left[i] = arr[start + i];
    }
    for (int i = 0; i < l2; i++) {
        right[i] = arr[mid + 1 + i];
    }
    int i = 0, j = 0, k = start;
    while (i < l1 && j < l2) {
        arr[k++] = left[i] < right[j] ? left[i++] : right[j++];
    }
    while (i < l1) {
        arr[k++] = left[i++];
    }
    while (j < l2) {
        arr[k++] = right[j++];
    }
}

void sort(int* arr, int start, int end) {
    if (start < end) {
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
}

void mergeSort(int* arr, int len) {
    sort(arr, 0, len - 1);
}

int main(int argc, char const* argv[]) {
    int arr[7] = {4, 5, 2, 1, 56, 1, 0};
    // int arr[7] = {3, 4, 1, 5, 1, 0, 19};
    mergeSort(arr, 7);
    printArr(arr, 7);
}
