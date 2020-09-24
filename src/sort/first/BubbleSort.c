/* bubble sort

   @since 2020-8-31 Monday 16:42
 */

#include <stdio.h>

void swap(int *arr, int i, int j);

void sort(int *arr, int size) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1])
                swap(arr, j, j + 1);
        }
    }
}

void swap(int *arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

int main(int argc, char const *argv[]) {
    int arr[7] = {3, 1, 2, 4, 1, 2, 5};
    sort(arr, 7);
    for (int i = 0; i < 7; i++)
        printf("%d ", arr[i]);
}
