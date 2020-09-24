#include "../tool.h"

/**
 * insertion sort
 * 
 * @since 2020-9-24 Thursday 14:45 - 15:54
 */
class InsertionSort {
    void swap(int* arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

   public:
    void sort(int* arr, int len) {
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
};

int main(int argc, char const* argv[]) {
    InsertionSort s;
    int arr[7] = {9, 1, 2, 14, 0, 5, 8};
    s.sort(arr, 7);
    printArr(arr, 7);

    int worst[7] = {7, 6, 5, 4, 3, 2, 1};
    s.sort(worst, 7);
    printArr(worst, 7);
}
