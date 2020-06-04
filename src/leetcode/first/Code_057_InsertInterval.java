package leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 *
 * @since 2020-6-4 Thursday
 */
public class Code_057_InsertInterval {
    static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] all = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, all, 0, intervals.length);
        all[all.length - 1] = newInterval;
        Arrays.sort(all, (a, b) -> a[0] - b[0]);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < all.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            int left = all[i][0], right = all[i][1];
            while (i < all.length - 1 && all[i + 1][0] <= right) {
                left = Math.min(left, all[i + 1][0]);
                right = Math.max(right, all[i + 1][1]);
                i++;
            }
            tmp.add(left);
            tmp.add(right);
            res.add(new ArrayList<>(tmp));
        }
        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i] = new int[]{res.get(i).get(0), res.get(i).get(1)};
        }
        return r;
    }

    static int[][] insert_(int[][] intervals, int[] newInterval) {
        int[][] all = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, all, 0, intervals.length);
        all[all.length - 1] = newInterval;
        Arrays.sort(all, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < all.length; i++) {
            int[] tmp = new int[2];
            int left = all[i][0], right = all[i][1];
            while (i < all.length - 1 && all[i + 1][0] <= right) {
                left = Math.min(left, all[i + 1][0]);
                right = Math.max(right, all[i + 1][1]);
                i++;
            }
            tmp[0] = left;
            tmp[1] = right;
            res.add(tmp);
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert_(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insert_(new int[][]{{1, 3}, {6, 9}}, new int[]{0, 10})));
    }
}
