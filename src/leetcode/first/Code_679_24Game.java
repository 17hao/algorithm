package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 24点游戏
 *
 * @since 2021-1-11 Monday 22:49 - 23:27
 */
public class Code_679_24Game {
    public boolean judgePoint24(int[] nums) {
        List<Double> l = new ArrayList<>();
        for (int n : nums) {
            l.add((double) n);
        }
        return helper(l);
    }

    private boolean helper(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 0.0001;
        }
        boolean valid = false;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                List<Double> remaining = new ArrayList<>(nums);
                double x = remaining.remove(j);
                double y = remaining.remove(i);
                remaining.add(Double.MIN_VALUE);
                remaining.set(remaining.size() - 1, x + y);
                valid |= helper(remaining);
                remaining.set(remaining.size() - 1, x - y);
                valid |= helper(remaining);
                remaining.set(remaining.size() - 1, y - x);
                valid |= helper(remaining);
                remaining.set(remaining.size() - 1, x * y);
                valid |= helper(remaining);
                if (x != 0) {
                    remaining.set(remaining.size() - 1, y / x);
                    valid |= helper(remaining);
                }
                if (y != 0) {
                    remaining.set(remaining.size() - 1, x / y);
                    valid |= helper(remaining);
                }
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        Code_679_24Game c = new Code_679_24Game();
        System.out.println(c.judgePoint24(new int[]{1, 2, 3, 4}));
        System.out.println(c.judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(c.judgePoint24(new int[]{1, 2, 1, 2}));
    }
}
