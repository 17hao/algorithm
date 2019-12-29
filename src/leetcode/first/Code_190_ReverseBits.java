package leetcode.first;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * @since 2019-12-29 Sunday 18:36
 */
public class Code_190_ReverseBits {
    static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(0b00000010100101000001111010011100));
        System.out.println(reverseBits(0b11111111111111111111111111111101));
    }
}
