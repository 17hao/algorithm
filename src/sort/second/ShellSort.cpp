#include <iostream>

#include "../tool.h"

/**
 * shell sort
 *
 * @since 2020-10-12 Monday 14:46
 */
class ShellSort {
   public:
    static void sort(int* arr, int count) {
        for (int gap = count / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < count; i++) {
                int tmp = arr[i];
                int j = i;
                for (; j >= gap && arr[j - gap] > arr[j]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }
};

int main(int argc, char const* argv[]) {
    int arr[5] = {5, 1, 4, 10, 2};
    ShellSort::sort(arr, 5);
    printArr(arr, 5);
}
