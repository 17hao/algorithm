package basic_class_01;

import tool.SortTestTool;

public class Code_02_SelectionSort {
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = SortTestTool.generateArray(10, 100);
        selectionSort(arr);
        printArray(arr);
    }
}