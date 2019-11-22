package archive.basic_class_01;

import tool.CommonTool;
import tool.SortTestTool;

public class Code_03_MergeSort {
    private static void mergeSort(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        //递归
        if (l < r) {
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    //排序并合并小的数组
    private static void merge(int[] arr, int l, int m, int r) {
        //申请额外空间定义一个辅助数组保存小数组
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;//左指针
        int p2 = m + 1;//右指针
        //将左右2个数组较小的数先写入help
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //将左右2个数组中较长的多出来的部分补充到help[]尾部
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //将辅助数组help[]换给arr[]
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }

    private static void printArray(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 100;
        int timeSize = 5000;
        boolean success = true;
        int[] arr1 = CommonTool.generateArray(maxSize, maxValue);
        int[] arr2 = SortTestTool.copyArray(arr1);
        for (int i = 0; i < timeSize; i++) {
            mergeSort(arr1, 0, arr1.length - 1);
            SortTestTool.comparator(arr2);
            if (!SortTestTool.isEqual(arr1, arr2)) {
                success = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked");
    }
}