package leetcode;

import java.util.HashSet;

/**
 * @author 17hao
 * @date 2019-04-25 16:06
 */
public class Code_136_SingleNumber {
    private static int singleNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>(arr.length);
        for (int n : arr) {
            if (!set.contains(n))
                set.add(n);
            else
                set.remove(n);
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,4};
        int res = singleNumber(arr);
        System.out.println(res);
    }
}
