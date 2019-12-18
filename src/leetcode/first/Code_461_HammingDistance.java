package leetcode.first;

/**
 * 计算汉明距离.两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * @since 2019-12-18 Wednesday
 */
public class Code_461_HammingDistance {
    static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(0, 1));
    }
}
