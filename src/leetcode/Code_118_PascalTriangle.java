package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 17hao
 * @date 2019-04-21 14:52
 */
public class Code_118_PascalTriangle {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pTriangle = new ArrayList<>();
        if (numRows == 0)
            return pTriangle;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(1);
        pTriangle.add(l1);
        if (numRows == 1)
            return pTriangle;
        l2.add(1);
        l2.add(1);
        pTriangle.add(l2);
        if (numRows == 2)
            return pTriangle;
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = pTriangle.get(pTriangle.size() - 1);
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 0; j < temp.size() - 1; j++) {
                next.add(temp.get(j) + temp.get(j + 1));
            }
            next.add(1);
            pTriangle.add(next);
        }
        return pTriangle;
    }

    public static void main(String[] args) {
        int n = 0;
        List<List<Integer>> res = generate(n);
        System.out.println(res);
    }
}
