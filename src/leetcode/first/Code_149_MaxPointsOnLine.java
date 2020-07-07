package leetcode.first;

import java.util.HashSet;
import java.util.Set;

/**
 * 直线上最多的点数
 * 
 * @since 2020-7-7 Tuesday 13：59
 */
class Code_149_MaxPointsOnLine {
    int maxPoints(int[][] points) {
        int len = points.length, max = 0;
        if (len < 3) {
            return len;
        }
        for (int i = 1; i < len; i++) {
            if (points[i][0] != points[i - 1][0] || points[i][1] != points[i - 1][1]) {
                break;
            }
            if (i == len - 1) {
                return len;
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                String key = getK(points[i][0], points[i][1], points[j][0], points[j][1]) + "@"
                        + getB(points[i][0], points[i][1], points[j][0], points[j][1]);

                if (set.contains(key)) {
                    continue;
                }
                int tmp = 0;
                for (int k = 0; k < len; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                            tmp++;
                        }
                    }
                }
                max = Math.max(tmp, max);
                set.add(key);
            }
        }
        return max + 2;
    }

    int _maxPoints(int[][] points) {
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

    private double getK(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return Double.POSITIVE_INFINITY;
        }
        return (y2 - y1) / (x2 - x1);
    }

    private double getB(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return Double.POSITIVE_INFINITY;
        }
        return y1 - (y1 - y2) / (x1 - x2) * x1;
    }

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        return (long) (y2 - y1) * (x - x1) == (long) (x2 - x1) * (y - y1);
    }

    public static void main(String[] args) {
        Code_149_MaxPointsOnLine c = new Code_149_MaxPointsOnLine();

        System.out.println(c._maxPoints(new int[][] { { 0, 0 }, { 1, 1 }, { 1, -1 } }));
        System.out.println(c._maxPoints(new int[][] { { 1, 2 }, { 2, 3 } }));
        System.out.println(c._maxPoints(new int[][] { { 1, 1 }, { 1, 1 }, { 2, 3 } }));
        System.out.println(c._maxPoints(new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } }));
        System.out.println(
                c._maxPoints(new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 }, { 4, 1 } }));
        System.out.println(c._maxPoints(new int[][] { { 1, 1 }, { 1, 1 }, { 1, 1, } }));
        System.out.println(c._maxPoints(
                new int[][] { { 1, 1 }, { 1, 1 }, { 0, 0 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 8 }, { 8, 9 } }));
    }
}