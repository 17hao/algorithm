package leetcode.second;

import java.util.Arrays;

/**
 * 最大网络延迟
 * 戴克斯特拉最短路径算法
 * 找出顶点间的最短路径
 * 距离数组记录m到每一个顶点的距离
 * ① 找到从m出发的未访问过的路径最短的顶点x,将距离记录在距离数组中.此时m -> x
 * ② 找到从x出发的未访问过的路径最短的顶点y
 * ③ 如果x能到y且m能到y,最短路径为2者的最小值;如果x能到y且m不能到y,最短路径为2者相加
 * ④ 遍历所有顶点集直到所有顶点都被访问过
 * ⑤ 遍历距离数组得出结果
 *
 * @since 2020-6-9 Tuesday 15:57
 */
public class Code_743_NetworkDelayTime {
    static int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for (int[] g : graph) {
            Arrays.fill(g, -1);
        }
        for (int[] t : times) {
            graph[t[0]][t[1]] = t[2];
        }

        // 顶点k到其他顶点的距离
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        for (int i = 1; i <= N; i++) {
            dist[i] = graph[K][i];
        }
        dist[K] = 0;

        boolean[] visited = new boolean[N + 1];
        visited[K] = true;

        for (int i = 1; i <= N; i++) {
            int minDist = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && dist[j] != -1 && dist[j] < minDist) {
                    minDist = dist[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            for (int j = 1; j <= N; j++) {
                if (graph[minIndex][j] != -1) {
                    if (dist[j] == -1) {
                        dist[j] = minDist + graph[minIndex][j];
                    } else {
                        dist[j] = Math.min(dist[minIndex] + graph[minIndex][j], dist[j]);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1)
                return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
}
