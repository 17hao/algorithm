package basic_class_01;

import java.util.Arrays;

public class Code_01_InsertionSort {
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

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

    // 参照组
    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // 随机生成一个数组,长度和值都随机
    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // 拷贝一个数组
    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 判断2个数组是否相同
    private static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int timeSize = 5000;
        int maxSize = 100;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < timeSize; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            comparator(arr1);
            insertionSort(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked!");
        int[] arr3 = generateRandomArray(maxSize, maxValue);
        insertionSort(arr3);
        printArray(arr3);
    }
}
