#include <iostream>

#include "../tool.h"

/**
 * merge sort
 *
 * @since 2020-9-25 Friday 14:20
 */
class MergeSort {
    void mergeSort(int* arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, r, mid);
        }
    }

    void merge(int* arr, int l, int r, int m) {
        // std::cout << "l: " << l << " r: " << r << " m: " << m << "\n";
        int n1 = m - l + 1, n2 = r - m;
        int a1[n1], a2[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            a2[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, pos = l;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                arr[pos++] = a1[i++];
            } else {
                arr[pos++] = a2[j++];
            }
        }
        while (i < n1) {
            arr[pos++] = a1[i++];
        }
        while (j < n2) {
            arr[pos++] = a2[j++];
        }
        // printArr(arr, 7);
    }

   public:
    void sort(int* arr, int len) {
        mergeSort(arr, 0, len - 1);
    }
};

int main(int argc, char const* argv[]) {
    MergeSort s;
    int arr[7] = {5, 2, 1, 6, 141, 90, 1};
    s.sort(arr, 7);
    printArr(arr, 7);
}
