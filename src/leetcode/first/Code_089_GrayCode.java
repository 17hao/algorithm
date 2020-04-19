package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * n位格雷码
 *
 * @since 2020-4-17 Friday 9:9
 */
public class Code_089_GrayCode {
    static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(0));
        System.out.println(grayCode(1));
        System.out.println(grayCode(2));
        System.out.println(grayCode(10));
    }
}
