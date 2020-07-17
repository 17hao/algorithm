package leetcode.first;

/**
 * 只存在一个的数字、
 * 
 * @since 2002-7-11 Saturday
 */
public class Code_137_SingleNum2 {
    static int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int n : nums) {
            a = a ^ n & ~b;
            b = b ^ n & ~a;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 1, 1, 1, 2 }));
        System.out.println(singleNumber(new int[] { 1, 1, 1, 3, 3, 3, 2 }));
    }
}