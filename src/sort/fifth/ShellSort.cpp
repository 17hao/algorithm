#include "../tool.h"

/**
 * shell sort
 *
 * @since 2020-12-16 Wednesday 16:06
 */
void sort(int* arr, int len) {
    for (int gap = len / 2; gap >= 1; gap /= 2) {
        for (int i = gap; i < len; i++) {
            int temp = arr[i];
            int j = i;
            for (; j - gap >= 0 && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j]  =temp;
        }
    }
}

int main(int argc, const char* argv[]) {
    int arr[8] = {4,5,1,2,4,6,10,9};
    sort(arr, 8);
    printArr(arr, 8);
}
