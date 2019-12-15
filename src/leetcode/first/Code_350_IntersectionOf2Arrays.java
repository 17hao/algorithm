package leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 两个数组的交集II
 *
 * @since 2019-12-15 Sunday
 */
public class Code_350_IntersectionOf2Arrays {
    static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int value : nums1) {
            if (map.containsKey(value)) {
                int count = map.remove(value) + 1;
                map.put(value, count);
            } else {
                map.put(value, 1);
            }
        }
        for (int value : nums2) {
            if (map.containsKey(value) && map.get(value) > 0) {
                temp.add(value);
                map.put(value, map.remove(value) - 1);
            }
        }
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 4, 5};
        int[] n2 = {1, 2, 3, 4, 5, 6};
        int[] n3 = {};
        int[] n4 = {4, 9, 5};
        int[] n5 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(n1, n2)));
        System.out.println(Arrays.toString(intersect(n1, n3)));
        System.out.println(Arrays.toString(intersect(n4, n5)));
    }
}
