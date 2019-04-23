package basic_class_01;

import tool.SortTestTool;

import static tool.CommonTool.generateArray;
import static tool.CommonTool.printArray;

public class Code_01_InsertionSort {
    /**
     * 用了swap的插入排序性能差，因为swap每次需要三次赋值
     * 而将数组整体右移每次只需要一次赋值
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[j + 1] = value;
        }
    }

    // private static void insertionSort(int[] arr) {
    //     if (arr == null || arr.length < 2) {
    //         return;
    //     }
    //     for (int i = 1; i < arr.length; i++) {
    //         for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
    //             swap(arr, j, j + 1);
    //         }
    //     }
    // }

    // private static void insertionSort(int[] arr) {
    //     if (arr == null && arr.length < 2) return;
    //     for (int i = 1; i < arr.length; i++) {
    //         for (int j = i; j > 0; j--) {
    //             if (arr[j] < arr[j - 1]) {
    //                 swap(arr, j, j - 1);
    //             }
    //         }
    //     }
    // }

    // private static void bubbleSort(int[] arr) {
    //     for (int i = arr.length - 1; i >= 0; i--) {
    //         for (int j = 0; j < i; j++) {
    //             if (arr[j] > arr[j + 1]) {
    //                 swap(arr, j, j + 1);
    //             }
    //         }
    //     }
    // }

    public static void main(String[] args) {
        int timeSize = 5;
        int maxSize = 100;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < timeSize; i++) {
            int[] arr1 = generateArray(maxSize, maxValue);
            int[] arr2 = SortTestTool.copyArray(arr1);
            SortTestTool.comparator(arr1);
            insertionSort(arr2);
            if (!SortTestTool.isEqual(arr1, arr2)) {
                success = false;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked!");
        int[] arr3 = generateArray(maxSize, maxValue);
        insertionSort(arr3);
        printArray(arr3);
    }
}
