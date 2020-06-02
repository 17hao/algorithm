package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角2
 *
 * @since 2020-5-25 Monday 9:32
 */
public class Code_119_PascalTriangle2 {
    static List<Integer> _getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>(), res = new ArrayList<>();
        pre.add(1);
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res = new ArrayList<>();
            res.add(1);
            for (int j = 1; j < i; j++) {
                res.add(pre.get(j) + pre.get(j  - 1));
            }
            res.add(1);
            pre = res;
        }
        return res;
    }

    static List<Integer> __getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int pre = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                int tmp = res.get(j);
                res.set(j, res.get(j) + pre);
                pre = tmp;
            }
            res.add(1);
        }
        return res;
    }

    // static List<Integer> getRow(int rowIndex) {
    //     List<Integer> res = new ArrayList<>();
    //     res.add(1);
    //     for (int i = 1; i <= rowIndex; i++) {
    //         for (int j = i - 1; j > 0; j--) {
    //             res.set(j, res.get(j - 1) + res.get(j));
    //         }
    //         res.add(1);
    //     }
    //     return res;
    // }

    public static void main(String[] args) {
        // System.out.println(getRow(0));
        // System.out.println(getRow(1));
        // System.out.println(getRow(2));
        // System.out.println(getRow(5));
        // System.out.println(getRow(33));
        // System.out.println(_getRow(0));
        // System.out.println(_getRow(1));
        // System.out.println(_getRow(2));
        // System.out.println(_getRow(3));
        // System.out.println(_getRow(5));
        // System.out.println(_getRow(33));
        System.out.println(__getRow(0));
        System.out.println(__getRow(1));
        System.out.println(__getRow(2));
        System.out.println(__getRow(3));
        System.out.println(__getRow(5));
        System.out.println(__getRow(33));
    }
}
