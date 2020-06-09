package leetcode.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫问题
 *
 * @since 2020-6-9 Tuesday 17:16
 */
public class Interview_062_JosephusProblem {
    private int res;

    int lastRemaining(int n, int m) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        helper(nums, m, 0);
        return res;
    }

    private void helper(List<Integer> nums, int m, int index) {
        if (nums.size() == 1) {
            res = nums.get(0);
            return;
        }
        index = (index + m - 1) % nums.size();
        nums.remove(index);
        helper(nums, m, index);
    }


    int _lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }


    public static void main(String[] args) {
        Interview_062_JosephusProblem i = new Interview_062_JosephusProblem();
        System.out.println(i.lastRemaining(5, 3)); // 0,1,2,3,4
        System.out.println(i.lastRemaining(10, 17)); // 0,1,2,3,4,5,6,7,8,9
        // System.out.println(i.lastRemaining(70866, 116922));
    }
}
