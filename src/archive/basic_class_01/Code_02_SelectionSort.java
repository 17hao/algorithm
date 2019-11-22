package archive.basic_class_01;

import tool.CommonTool;

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
            CommonTool.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = CommonTool.generateArray(10, 100);
        selectionSort(arr);
        CommonTool.printArray(arr);
    }
}