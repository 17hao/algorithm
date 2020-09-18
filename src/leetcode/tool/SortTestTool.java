package leetcode.tool;

import java.util.Arrays;

/**
 * @author 17hao
 * @update 2019/4/7
 */
public class SortTestTool {
    /* 用标准库提供的排序算法作为参照 */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /* 拷贝该数组 */
    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /* 比较2个经过排序后的数组是否相同 */
    public static boolean isEqual(int[] arr1, int[] arr2) {
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
}
