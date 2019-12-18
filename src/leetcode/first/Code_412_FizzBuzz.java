package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * @since 2019-12-18 Wednesday
 */
public class Code_412_FizzBuzz {
    static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = "";
            if (i % 3 == 0) {
                s = s + "Fizz";
            }
            if (i % 5 == 0) {
                s = s + "Buzz";
            }
            if (s.equals("")) {
                s = s + i;
            }
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(1));
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
    }
}
