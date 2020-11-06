#include <iostream>

/**
 * build min heap
 *
 * @since 2020-11-6 Friday
 */
void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void siftUp(int* arr, int start, int end) {
    int root = start;
    while (root * 2 + 1 <= end) {
        int left = root * 2 + 1;
        int right = left + 1;
        int min = root;
        if (arr[left] < arr[min]) {
            min = left;
        }
        if (right <= end && arr[right] < arr[min]) {
            min = right;
        }
        if (min == root) {
            break;
        } else {
            swap(arr, min, root);
            root = min;
        }
    }
}

void heapify(int* arr, int len) {
    int start = len - 1;
    while (start >= 0) {
        siftUp(arr, start--, len - 1);
    }
}

int main(int argc, char const* argv[]) {
    int arr[7] = {10, 0, 1, 5, 6, 9, 20};
    heapify(arr, 7);
    for (int i = 0; i < 7; i++) {
        std::cout << arr[i] << " ";
    }
}
