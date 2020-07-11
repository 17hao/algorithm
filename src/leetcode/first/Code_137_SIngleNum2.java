package leetcode.first;

public class Code_137_SIngleNum2 {
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