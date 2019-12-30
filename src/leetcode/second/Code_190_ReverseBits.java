package leetcode.second;

/**
 * 颠倒二进制位
 *
 * @since 2019-12-30 14:41
 */
public class Code_190_ReverseBits {
    static int reverseBits(int n) {
        // wrong answer:
        // int res = 0;
        // for (int i = 0; i < 32; i++) {
        //     if ((n & 1) == 1) {
        //         res++;
        //     }
        //     res <<= 1;
        //     n >>= 1;
        // }
        // return res;

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(reverseBits(0b00000010100101000001111010011101)));
        System.out.println(Integer.toBinaryString(reverseBits(0b11111111111111111111111111111101)));
    }
}
