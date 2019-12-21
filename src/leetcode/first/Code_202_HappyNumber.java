package leetcode.first;

/**
 * 快乐数
 *
 * @since 2019-12-21 Saturday
 */
public class Code_202_HappyNumber {
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
            int temp = n % 10;
            result += temp * temp;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code_202_HappyNumber().isHappy(19));
        System.out.println(new Code_202_HappyNumber().isHappy(29));
        System.out.println(new Code_202_HappyNumber().isHappy(39));
        System.out.println(new Code_202_HappyNumber().isHappy(1));
    }
}
