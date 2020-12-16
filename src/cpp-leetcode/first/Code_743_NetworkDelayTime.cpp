#include <iostream>
#include <vector>
#include <climits>

/**
 * network delay time
 *
 * @since 2020-12-16 23:05
 */
class Solution {
    int findMinDelayNode(int* delay, bool* visited, int N) {
        int res = 0, min = INT_MAX;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && delay[i] < min) {
                res = i;
                min = delay[i];
            }
        }
        return res;
    }

public:
    int networkDelayTime(std::vector<std::vector<int>>& times, int size, int source) {
        int* delay = new int[size];
        bool* visited = new bool[size];
        int graph[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph[i][j] = -1;
            }
        }
        for (auto t : times) {
            graph[t[0] - 1][t[1] - 1] = t[2];
        }
        for (int i = 0; i < size; i++) {
            delay[i] = INT_MAX;
        }
        delay[source - 1] = 0;
        for (int i = 0; i < size; i++) {
            int curNode = findMinDelayNode(delay, visited, size);
            visited[curNode] = true;
            for (int j = 0; j < size; j++) {
                if (delay[curNode] != INT_MAX && graph[curNode][j] >= 0 && delay[curNode] + graph[curNode][j] < delay[j]) {
                    delay[j] = delay[curNode] + graph[curNode][j];
                }
            }
        }
        int res = INT_MIN;
        for (int i = 0 ; i < size; i++) {
            if (delay[i] == INT_MAX) {
                return -1;
            }
            if (delay[i] > res) {
                res = delay[i];
            }
        }
        return res;
    }
};

int main(int argc, const char* argv[]) {
    std::vector<std::vector<int>> times = {{2,1,1}, {2,3,1},{3,4,1}};
    //std::vector<std::vector<int>> times = {{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
    Solution s;
    int res = s.networkDelayTime(times, 4, 2);
    std::cout << "res: " << res << "\n";

}
