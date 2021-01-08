package leetcode.first;

import java.util.Arrays;

/**
 * 比特位计数
 * 
 * @since 2021-1-8 Friday
 */
public class Code_338_CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Code_338_CountingBits c = new Code_338_CountingBits();
        System.out.println(Arrays.toString(c.countBits(2)));
        System.out.println(Arrays.toString(c.countBits(5)));
        System.out.println(Arrays.toString(c.countBits(10)));
    }
}
