#include <cstdlib>
#include <iostream>
#include <limits>
#include <queue>
#include <vector>

#define L 9

/**
 * dijkstra's algorithm
 *
 * @since 2020-9-29 Tuesday
 */
class Dijkstra {
    int minDisNode(int dist[], bool track[]) {
        int min = INT_MAX, res;
        for (int i = 0; i < L; i++) {
            if (!track[i] && dist[i] <= min) {
                min = dist[i];
                res = i;
            }
        }
        return res;
    }

   public:
    int* shortestPath(int graph[L][L], int source) {
        int* dist = new int[L];
        bool* track = new bool[L];
        for (int i = 0; i < L; i++) {
            dist[i] = INT_MAX;
        }
        dist[source] = 0;
        for (int i = 0; i < L - 1; i++) {
            int u = minDisNode(dist, track);
            track[u] = true;
            for (int v = 0; v < L; v++) {
                if (!track[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        std::vector<int> res;
        for (int i = 0; i < L; i++) {
            res.push_back(dist[i]);
        }
        return dist;
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
    Dijkstra alg;
    int* res = alg.shortestPath(graph, 0);
    std::cout << "vertex    distance\n";
    for (int i = 0; i < L; i++) {
        std::cout << "  " << i << "         " << res[i] << std::endl;
    }
}
