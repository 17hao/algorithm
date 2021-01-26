package leetcode.first;

import java.util.Arrays;

/**
 * sort an array
 * 
 * @since 2021-1-26 Tuesday 17:41
 */
public class Code_912_SortArray {
    public int[] sortArray(int[] arr) {
        quickSort(arr);
        return arr;
    }

    private void quickSort(int[] arr) {
        partition(arr, 0, arr.length - 1);
    }

    private void partition(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        swap(arr, start, end);
        int pivot = arr[end];
        int small = start - 1, big = end;
        int i = start;
        while (i < big) {
            if (arr[i] > pivot) {
                swap(arr, i, --big);
            } else if (arr[i] < pivot) {
                swap(arr, i++, ++small);
            } else {
                i++;
            }
        }
        swap(arr, end, big);
        // System.out.println(Arrays.toString(arr));
        partition(arr, start, small);
        partition(arr, big + 1, end);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 5, 4, 2, 1, 10, 124 };
        Code_912_SortArray c = new Code_912_SortArray();
        System.out.println(Arrays.toString(c.sortArray(arr)));
    }
}
