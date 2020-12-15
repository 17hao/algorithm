#include <iostream>

#include "../tool.h"

/**
 * heap sort
 *
 * @since 2020-10-12 Monday 11:03
 */
class HeapSort {
    void swap(int* arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * build max heap.
     */
    void heapify(int* arr, int count) {
        int start = (count - 2) / 2;
        while (start >= 0) {
            siftDown(arr, start--, count - 1);
        }
    }

    void siftDown(int* arr, int start, int end) {
        int root = start;
        while (root * 2 + 1 <= end) {
            int left = root * 2 + 1;
            int right = left + 1;
            int largest = root;
            if (arr[largest] < arr[left]) {
                largest = left;
            }
            if (right <= end && arr[largest] < arr[right]) {
                largest = right;
            }
            if (largest == root) {
                break;
            } else {
                swap(arr, largest, root);
                root = largest;
            }
        }
    }

   public:
    void sort(int* arr, int n) {
        heapify(arr, n);
        int end = n - 1;
        while (end > 0) {
            swap(arr, 0, end--);
            siftDown(arr, 0, end);
        }
    }
};

int main(int argc, char const* argv[]) {
    HeapSort s;
    int arr[5] = {6, 5, 4, 3, 2};
    s.sort(arr, 5);
    printArr(arr, 5);
    std::cout << "\n";
}
