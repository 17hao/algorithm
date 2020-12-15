#include <iostream>
#include "../tool.h"

/**
 * heap sort
 * 堆排序是选择排序的加强版，它们的基本思想都是挑选后续数组中最小（大）的元素。
 * 借助堆这种数据结构，堆排序能将挑选动作的时间复杂度降低到O(logN)，而选择排序在这一步骤的时间复杂度是O(N)。
 * 堆这种数据结构还可以用在Dijkstra算法和Kruskal算法中降低挑选最小值这一子步骤的时间复杂度，从而降低整体的时间复杂度。
 *
 * @since 2020-12-13 Sunday 18:52 - 19:13
 */
void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void siftDown(int* arr, int start, int end) {
    int root = start;
    int largest = root;
    while (root * 2 + 1 <= end) {
	int left = root * 2 + 1;
        int right = left + 1;
	if (arr[largest] < arr[left]) {
	    largest = left;
	}
	if (right <= end && arr[largest] < arr[right]) {
	    largest = right;
	}
	if (root == largest) {
	    break;
	}
	swap(arr, root, largest);
	root = largest;
    }
}

void heapify(int* arr, int len) {
    int start = (len - 2) / 2;
    while (start >= 0) {
    	siftDown(arr, start--, len - 1);
    }
}

void sort(int* arr, int len) {
    heapify(arr, len);
    int tail = len - 1;
    while (tail > 0) {
        swap(arr, 0, tail--);
	siftDown(arr, 0, tail);
    }
}

int main(int argc, const char* argv[]) {
    int arr[7] = {5, 1, 0, 4, 10, 9, 2};
    sort(arr, 7);
    printArr(arr, 7);
}
