package leetcode.first;

import java.util.Arrays;

/**
 * 网络延迟时间(最短路径)
 *
 * @since 2020-1-30
 */
public class Code_743_NetworkDelayTime {
    static int networkDelayTime(int[][] times, int N, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for (int[] t : graph) Arrays.fill(t, -1);
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        for (int i = 1; i <= N; i++) {
            dist[i] = graph[K][i];
        }
        dist[K] = 0;

        boolean[] visited = new boolean[N + 1];
        visited[K] = true;

        for (int i = 1; i <= N - 1; i++) {
            int minDis = Integer.MAX_VALUE;
            int minIndex = 1;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && dist[j] != -1 && dist[j] < minDis) {
                    minDis = dist[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            for (int j = 1; j <= N; j++) {
                if (graph[minIndex][j] != -1) {
                    if (dist[j] != -1) {
                        dist[j] = Math.min(graph[minIndex][j] + dist[minIndex], dist[j]);
                    } else {
                        dist[j] = graph[minIndex][j] + dist[minIndex];
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
}
