package archive.basic_class_02;

import tool.SortTestTool;

import static tool.CommonTool.*;

@SuppressWarnings("all")
public class Code_01_QuickSort {
    /*
    经典快排
    数组最后一个数作为参照点
    改良版
    随机选择数组的一个元素
     */

    /*
    public static void quickSort(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2) {
            return;
        }
        if (l < r) {
            int[] tmp = partition(arr, l, r);
            quickSort(arr, l, tmp[0] - 1);
            quickSort(arr, tmp[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int small = l - 1;
        int big = r;//经典快排将最后一个数作为基准点,可以直接包含到大于区域
        while (l < big) {
            if (arr[l] < arr[r]) {
                swap(arr, ++small, l++);
            } else if (arr[l] == arr[r]) {
                l++;
            } else if (arr[l] > arr[r]) {
                swap(arr, --big, l);
            }
        }
        swap(arr, big, r);//一开始将最后一个数包进了大于区域 要将它置换出来
        return new int[]{small + 1, big};//返回==基准数的一片区域的左右边界
    }
    */

    /*
    改良版快排
    随机选取一个数作为基准数,和最后一个数交换
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2) {
            return;
        }
        if (l < r) {
            int[] tmp = partition(arr, l, r);
            quickSort(arr, l, tmp[0] - 1);
            quickSort(arr, tmp[1] + 1, r);
        }
    }

    @SuppressWarnings("Duplicates")
    public static int[] partition(int[] arr, int left, int right) {
        int small = left - 1;
        int big = right;
        int seed = left + (int) (Math.random() * (right - left + 1));
        swap(arr, seed, right);
        while (left < big) {
            if (arr[left] < arr[right]) {
                swap(arr, ++small, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --big, left);
            } else {
                left++;
            }
        }
        swap(arr, big, right);
        return new int[]{small + 1, big};
    }

    public static void main(String[] args) {
        int timeSize = 1000;
        boolean success = true;
        int[] arr1 = generateArray(20, 100);
        int[] arr2 = SortTestTool.copyArray(arr1);
        for (int i = 0; i < timeSize; i++) {
            quickSort(arr1, 0, arr1.length - 1);
            SortTestTool.comparator(arr2);
            if (!SortTestTool.isEqual(arr1, arr2)) {
                success = false;
                printArray(arr1);
                break;
            }
        }
        System.out.print(success ? "Nice!" : "Fucking fucked!");
    }
}
