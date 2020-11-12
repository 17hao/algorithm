#include "../tool.h"

/**
 * selection sort
 * 一般思路下的选择排序是unstable，也可以将选择排序实现成stable
 * 稳定版本的选择排序要求先挑选最小的元素，将最小的元素插入到待排序数组的最前端，将剩余元素向后推，而不是两两交换
 *
 * 选择排序为了挑选最小（大）元素，必须遍历剩下所有的元素，插入排序向前查找，但是不一定要遍历全部元素，可能在半路就找到合适的位置
 * 堆排序可以看做选择排序的变种，借助堆这种数据结构，查找最小（大）的元素时间复杂度降低O(logN)
 *
 * 在数据量较小时选择、插入排序的时间效率比归并、快速排序更高，因为后2种分治算法在递归调用中花费了额外的时间
 *
 * @since 2020-11-12 Thursday 13:50
 */
void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void selectionSort(int* arr, int len) {
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
    int arr[7] = {4, 5, 1, 2, 4, 1, 0};
    selectionSort(arr, 7);
    printArr(arr, 7);
}
