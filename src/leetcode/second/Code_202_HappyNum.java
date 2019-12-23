package leetcode.second;

/**
 * 快乐数
 *
 * @since 2019-12-23 Monday
 */
public class Code_202_HappyNum {
    boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    private int bitSquareSum(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code_202_HappyNum().isHappy(19));
        System.out.println(new Code_202_HappyNum().isHappy(7));
        System.out.println(new Code_202_HappyNum().isHappy(21));
        System.out.println(new Code_202_HappyNum().isHappy(23));
    }
}
