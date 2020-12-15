#include <iostream>

#include "../tool.h"

void heapify(int* arr, int len);
void siftDown(int* arr, int start, int end);
void swap(int* arr, int i, int j);

/**
 * heap sort
 *
 * @since 2020-11-6 Friday 15:50
 */
void sort(int* arr, int len) {
    heapify(arr, len);
    for (int i = len - 1; i > 0;) {
        swap(arr, 0, i);
        siftDown(arr, 0, --i);
    }
}

void heapify(int* arr, int len) {
    // 一种heapify的典型错误
    // int start = 0, end = 0;
    // while (end < len) {
    //     siftDown(arr, start, end++);
    // }
    int start = (len - 2) / 2;
    while (start >= 0) {
        siftDown(arr, start--, len - 1);
    }
}

void siftDown(int* arr, int start, int end) {
    int root = start;
    while (root * 2 + 1 <= end) {
        int left = root * 2 + 1;
        int right = left + 1;
        int largest = root;
        if (arr[left] > arr[largest]) {
            largest = left;
        }
        if (right <= end && arr[right] > arr[largest]) {
            largest = right;
        }
        if (root == largest) {
            break;
        } else {
            swap(arr, root, largest);
            root = largest;
        }
    }
}

void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

int main(int argc, char const* argv[]) {
    int arr[7] = {5, 4, 2, 0, 19, 2, 10};
    sort(arr, 7);
    printArr(arr, 7);
}
