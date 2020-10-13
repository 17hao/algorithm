#include <iostream>

/**
 * quick sort
 *
 * @since 2020-10-13 Tuesday 13:48 - 14:08
 */
class QuickSort {
    void swap(int *arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    void helper(int *arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = left + (right - left) / 2;
        swap(arr, pivot, right);
        int small = left - 1, big = right;
        for (int i = left; i < big;) {
            if (arr[i] > arr[right]) {
                swap(arr, i, --big);
            } else if (arr[i] < arr[right]) {
                i++;
                small++;
            } else {
                i++;
            }
        }
        swap(arr, right, big++);
        helper(arr, left, small);
        helper(arr, big, right);
    }

   public:
    void sort(int *arr, int n) {
        helper(arr, 0, n - 1);
    }
};

int main(int argc, char const *argv[]) {
    int arr[7] = {5, 3, 4, 2, 1, 65, 2};
    QuickSort s;
    s.sort(arr, 7);
    for (int i = 0; i < 7; i++) {
        std::cout << arr[i] << " ";
    }
}
