#include <iostream>
#include <vector>

#define INF 9999

/**
 * floyad-warshall algorithm
 *
 * @since 2020-9-29 Tuesday 16:04 - 16:20
 */
class FloyadWarshall {
   public:
    void shortestPath(std::vector<std::vector<int>>& dist) {
        int s = dist.size();
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                for (int k = 0; k < s; k++) {
                    if (dist[j][i] + dist[i][k] < dist[j][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
    }
};

int main(int argc, char const* argv[]) {
    std::vector<std::vector<int>> dist = {
        {0, 1, 4, 6, 6}, {INF, 0, INF, 2, INF}, {INF, INF, 0, INF, 8}, {INF, 3, 7, 0, 9}, {INF, INF, INF, INF, 0}};
    FloyadWarshall alg;
    alg.shortestPath(dist);
    for (auto x : dist) {
        for (int i : x) {
            if (i == INF) {
                std::cout << "INF ";
            } else {
                std::cout << i << "   ";
            }
        }
        std::cout << std::endl;
    }
}
