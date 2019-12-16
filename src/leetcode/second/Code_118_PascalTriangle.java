package leetcode.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @since 2019-12-16 Monday
 */
public class Code_118_PascalTriangle {
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = result.get(i - 1);
            List<Integer> l = new ArrayList<>();
            l.add(1);
            for (int j = 1; j < preRow.size(); j++) {
                l.add(preRow.get(j - 1) + preRow.get(j));
            }
            l.add(1);
            result.add(l);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
    }
}
