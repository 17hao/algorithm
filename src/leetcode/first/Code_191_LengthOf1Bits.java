package leetcode.first;

/**
 * 计算汉明重量(Hamming weight)
 *
 * @since 2019-12-28 Saturday
 */
public class Code_191_LengthOf1Bits {
    static int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    static int hammingWeightV2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
        System.out.println(hammingWeight(31));
        System.out.println(hammingWeight(0b00000000000000000000000000001011));
        System.out.println("===");
        System.out.println(hammingWeightV2(1));
        System.out.println(hammingWeightV2(31));
        System.out.println(hammingWeightV2(0b00000000000000000000000000001011));
    }
}
