#include <iostream>

/**
 * merge sort
 *
 * @since 2020-10-14 Wednesday 13:41 - 13:58
 */
class MergeSort {
    void merge(int* arr, int l, int m, int r) {
        int left = m - l + 1, right = r - m;
        int tmpL[left], tmpR[right];
        for (int i = 0; i < left; i++) {
            tmpL[i] = arr[l + i];
        }
        for (int i = 0; i < right; i++) {
            tmpR[i] = arr[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < left && j < right) {
            arr[k++] = tmpL[i] < tmpR[j] ? tmpL[i++] : tmpR[j++];
        }
        if (i < left) {
            arr[k++] = tmpL[i++];
        }
        if (j < right) {
            arr[k++] = tmpR[j++];
        }
    }

    void doMergeSort(int* arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            doMergeSort(arr, l, mid);
            doMergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

   public:
    void sort(int* arr, int n) {
        doMergeSort(arr, 0, n - 1);
    }
};

int main(int argc, char const* argv[]) {
    MergeSort s;
    int arr[7] = {3, 4, 1, 5, 1, 0, 19};
    s.sort(arr, 7);
    for (int i = 0; i < 7; i++) {
        std::cout << arr[i] << " ";
    }
}
