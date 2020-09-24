#include <iostream>

#include "../tool.h"

/**
 * shell sort
 *
 * @since 2020-9-24 Thursday
 */
class ShellSort {
   public:
    void sort(int* arr, int len) {
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int tmp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > tmp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }
};

int main(int argc, char const* argv[]) {
    ShellSort s;
    int arr[7] = {7, 12, 2, 5, 1, 0, 9};
    s.sort(arr, 7);
    printArr(arr, 7);
}
