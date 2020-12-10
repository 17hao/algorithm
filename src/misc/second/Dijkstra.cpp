#include <iostream>
#include "../tool.h"

#define L 9
#define MAX_INT 0x7fffffff

/**
 * dijkstra's algorithm
 * 
 * @since 2020-10-8 Thursday 17:00 - 17:32
 */
class Dijkstra {
    int minDisNode(int dist[], bool track[]) {
        int min = MAX_INT, res = 0;
        for (int i = 0; i < L; i++) {
            if (dist[i] < min && !track[i]) {
                min = dist[i];
                res = i;
            }
        }
        return res;
    }

   public:
    int* shortestPath(int graph[L][L], int src) {
        int* dist = new int[L];
        bool* track = new bool[L];
        for (int i = 0; i < L; i++) {
            dist[i] = MAX_INT;
        }
        dist[src] = 0;
        for (int i = 0; i < L - 1; i++) {
            int u = minDisNode(dist, track);
            track[u] = true;
            for (int v = 0; v < L; v++) {
                if (!track[v] && graph[u][v] && dist[u] != MAX_INT && dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }
};

int main(int argc, char const* argv[]) {
    Dijkstra alg;
    int graph[L][L] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},  {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2},
                       {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0, 0},
                       {0, 0, 0, 0, 0, 2, 0, 1, 6},  {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    int* res = alg.shortestPath(graph, 0);
    printNodeDistance(res, L, 0);
}