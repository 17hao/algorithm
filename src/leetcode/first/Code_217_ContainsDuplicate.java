package leetcode.first;

import java.util.HashSet;

/**
 * @author 17hao
 * @date 2019-04-26 10:45
 */
public class Code_217_ContainsDuplicate {
    private static boolean containsDuplicate(int[] arr) {
        boolean res = false;
        if (arr.length == 0) {
            return false;
        } else {
            HashSet<Integer> set = new HashSet<>(arr.length - 1);
            for (int n : arr) {
                if (set.contains(n)) {
                    res = true;
                } else {
                    set.add(n);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] arr = {};
        boolean res = containsDuplicate(arr);
        System.out.println(res);
    }
}
