package archive.basic_class_01;

import tool.CommonTool;

import static tool.CommonTool.generateArray;
import static tool.CommonTool.swap;

public class Code_00_BubbleSort {
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = generateArray(10, 10);
        bubbleSort(arr);
        CommonTool.printArray(arr);
    }
}
