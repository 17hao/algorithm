#include <iostream>
#include <vector>

#define L 9
#define INF 9999

/**
 * floyad-warshall algorithm
 *
 * @since 2020-9-29 Tuesday 16:04 - 16:20
 */
class FloyadWarshall {
   public:
    void shortestPath(int dist[][L]) {
        int s = L;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                for (int k = 0; k < s; k++) {
                    if (dist[j][i] == 0 || dist[i][k] == 0) {
                        continue;
                    }
                    if ((dist[j][k] == 0 && j != k) || dist[j][i] + dist[i][k] < dist[j][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
    }
};

int main(int argc, char const* argv[]) {
    int graph[L][L] = {
        {0, 4, 0, 0, 0, 0, 0, 8, 0},  
        {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
        {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},  
        {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
        {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };
    std::vector<std::vector<int>> dist = {
        {0, 1, 4, 6, 6}, {INF, 0, INF, 2, INF}, {INF, INF, 0, INF, 8}, {INF, 3, 7, 0, 9}, {INF, INF, INF, INF, 0}};
    FloyadWarshall alg;
    alg.shortestPath(graph);
    // for (auto x : dist) {
    //     for (int i : x) {
    //         if (i == INF) {
    //             std::cout << "INF ";
    //         } else {
    //             std::cout << i << "   ";
    //         }
    //     }
    //     std::cout << std::endl;
    // }
    for (int i = 0; i < L; i++) {
        for (int j = 0; j < L; j++) {
            std::cout << graph[i][j] << " ";
        }
        std::cout << "\n";
    }
}
