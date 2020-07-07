/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 *
 * https://leetcode-cn.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (22.65%)
 * Likes:    155
 * Dislikes: 0
 * Total Accepted:    13.5K
 * Total Submissions: 59.7K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 
 * 示例 1:
 * 
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length, max = 0;
        if (len < 3) {
            return len;
        }
        for (int i = 1; i < len; i++) {
            if (points[i][0] != points[i - 1][0] || points[i][1] != points[i - 1][0]) {
                break;
            }
            if (i == len - 1) {
                return len;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = 0;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                for (int k = 0; k < len; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                            tmp++;
                        }
                    }
                }
                max = Math.max(max, tmp);
            }
        }
        return max + 2;
    }

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        return (long) (y2 - y1) * (x - x1) == (long) (x2 - x1) * (y - y1);
    }
}
// @lc code=end
