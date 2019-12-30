package leetcode.second;

/**
 * 计算汉明重量(hamming weight)
 *
 * @since 2019-12-30 Monday 14:34
 */
public class Code_191_LengthOf1Bits {
    static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(0b00000000000000000000000000001011));
        System.out.println(hammingWeight(0b11111111111111111111111111111101));
    }
}
