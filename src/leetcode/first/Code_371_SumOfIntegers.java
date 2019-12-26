package leetcode.first;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * @since 2019-12-26 Thursday 13:27
 */
public class Code_371_SumOfIntegers {
    static int getSum(int a, int b) {
         while (b != 0) {
             int temp = a ^ b;
             b = (a & b) << 1;
             a = temp;
         }
         return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(4, 9));
        System.out.println(getSum(1, 999));
        System.out.println(getSum(55, 55));
        System.out.println(getSum(5, 7));
    }
}
