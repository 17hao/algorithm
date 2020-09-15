package misc.first;

import java.util.Arrays;

import tool.CommonTool;

/**
 * quick sort
 * 
 * @since 2020-8-5 Wednesday 16:33 - 17:34
 */
public class QuickSort {
    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        helper(arr, 0, arr.length - 1);
    }

    private static void helper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int small = start - 1, large = end;
        int i = start, j = end - 1;
        while (i <= j) {
            if (arr[i] > arr[end]) {
                CommonTool.swap(arr, i, j--);
                large--;
            } else if (arr[i] < arr[end]) {
                CommonTool.swap(arr, ++small, i++);
            } else {
                i++;
            }
        }
        CommonTool.swap(arr, large++, end);
        helper(arr, start, small);
        helper(arr, large, end);
    }

    public static void main(String[] args) {
        int[] a1 = new int[] { 5, 4, 2, 1, 51, 2 };
        int[] a2 = new int[] { 5, 2, 4, 1, 2, 1, 5, 1, 1, 1541 };
        int[] a3 = new int[] { 5, 2 };
        sort(a1);
        sort(a2);
        sort(a3);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
    }
}