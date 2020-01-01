package leetcode.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 *
 * @since 2020-1-1
 */
public class Code_056_MergeIntervals {
    static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[++i][1]);
            }
            i++;
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{3, 2}, {1, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 2}, {1, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{3, 2}, {1, 5}, {5, 10}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}})));
    }
}
