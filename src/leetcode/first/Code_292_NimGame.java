package leetcode.first;

/**
 * @author 17hao
 * @date 2019-05-01 15:08
 */
public class Code_292_NimGame {
    private static boolean canWinNim(int n) {
        return n % 4 > 0;
    }

    public static void main(String[] args) {
        int num = 10;
        boolean res = canWinNim(num);
        System.out.println(res);
    }
}
