package leetcode.zeroth;

import tool.CommonTool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2个数组的交集
 *
 * @author sqh
 * @date 2018-12-18
 */
public class Code_349_IntersectionArrays {
    private static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        // nums1去除重复元素
        for (int num : nums1) {
            set.add(num);
        }
        List<Integer> resList = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                resList.add(num);
                // 移除已经找到的元素
                set.remove(num);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = CommonTool.generateArray(10, 3);
        int[] arr2 = CommonTool.generateArray(10, 3);
        int[] res = intersection(arr1, arr2);
        CommonTool.printArray(res);
    }
}
