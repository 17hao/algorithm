#include <iostream>

#include "../tool.h"

/**
 * selection sort
 *
 * @since 2020-9-24 Thursday 10:15 - 10:24
 */
class SelectionSort {
   private:
    void swap(int* arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

   public:
    void sort(int* arr, int len) {
        int pos = 0;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, pos++, minIndex);
        }
    }
};

int main(int argc, char const* argv[]) {
    SelectionSort s;

    int arr[7] = {3, 1, 2, 4, 1, 2, 4};
    s.sort(arr, 7);
    printArr(arr, 7);
    std::cout << "\n";

    /*
        worst performance
        O(n^2) comparisions
        0(n) swaps
    */
    int worst[7] = {7, 6, 5, 4, 3, 2, 1};  // worst performance
    s.sort(worst, 7);
    printArr(arr, 7);
    std::cout << "\n";

    /*
        best performance
        O(n^2) comparisions
        O(1) swaps
    */
    int best[7] = {1, 2, 3, 4, 5, 6, 7};
    s.sort(best, 7);
    printArr(arr, 7);
    std::cout << "\n";
}
