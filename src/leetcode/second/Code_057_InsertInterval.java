package leetcode.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 * 
 * @since 2020-7-20 Monday 18:22 - 18:45
 */
public class Code_057_InsertInterval {
    static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] tmp = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, tmp, 0, intervals.length);
        tmp[tmp.length - 1] = newInterval;
        Arrays.sort(tmp, (m, n) -> (m[0] - n[0]));
        return merge(tmp);
    }

    private static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[1][1]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 })));
        System.out.println(Arrays.deepToString(
                insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 })));
    }
}