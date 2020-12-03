#include <iostream>

/**
 * selection sort
 *
 * @since 2020-12-3 Thursday 19:35
 */
void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void sort(int* arr, int len) {
    for (int i = 0; i < len; i++) {
        int min = i;
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        swap(arr, min, i);
    }
}

int main(int argc, char const* argv[]) {
    int arr[7] = {3, 1, 4, 1, 10, 2, 9};
    sort(arr, 7);
    for (int i = 0; i < 7; i++) {
        std::cout << arr[i] << " ";
    }
}
