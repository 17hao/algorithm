#include <cstdlib>
#include <iostream>

#include "../Tool.h"

/**
 * quick sort
 *
 * @since 2020-9-24 Thursday
 */
class QuickSort {
   private:
    void swap(int* arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    void helper(int* arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = std::rand() % (end - start + 1) + start;
        int small = start - 1, big = end, i = start, j = end - 1;
        swap(arr, pivot, end);
        while (i <= j) {
            if (arr[i] > arr[end]) {
                swap(arr, i, j--);
                big--;
            } else if (arr[i] < arr[end]) {
                swap(arr, i++, ++small);
            } else {
                i++;
            }
        }
        swap(arr, big++, end);
        helper(arr, start, small);
        helper(arr, big, end);
    }

   public:
    void sort(int* arr, int len) {
        helper(arr, 0, len - 1);
    }
};

int main(int argc, char const* argv[]) {
    QuickSort s;
    int arr[7] = {9, 6, 1, 1, 10, 123, 6};
    s.sort(arr, 7);
    printArr(arr, 7);

    int worst[7] = {7, 6, 5, 4, 3, 2, 1};
    s.sort(worst, 7);
    printArr(worst, 7);
}
