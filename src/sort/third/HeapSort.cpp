#include "../tool.h"

/**
 * heap sort
 *
 * @since 2020-11-13 Friday 15:36
 */
void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void siftDown(int* arr, int start, int end) {
    int root = start;
    int largest = root;
    while (root * 2 + 1 <= end) {
        int left = root * 2 + 1;
        int right = left + 1;
        if (arr[largest] < arr[left]) {
            largest = left;
        }
        if (right <= end && arr[largest] < arr[right]) {
            largest = right;
        }
        if (root == largest) {
            break;
        }
        swap(arr, root, largest);
        root = largest;
    }
}

void heapify(int* arr, int len) {
    int start = len - 1;
    while (start >= 0) {
        siftDown(arr, start--, len - 1);
    }
}

void sort(int* arr, int len) {
    heapify(arr, len);
    int i = len - 1;
    while (i > 0) {
        swap(arr, 0, i--);
        siftDown(arr, 0, i);
    }
}

int main(int argc, char const* argv[]) {
    int arr[7] = {5, 4, 2, 1, 7, 1, 10};
    sort(arr, 7);
    printArr(arr, 7);
}
