#include <iostream>
#include <limits>

#define SIZE 9

/**
 * Floyd-Warshall's algorithm
 * 从几个维度去比较Floyd和Dijkstra算法的适用范围:
 * 1. 有向图 or 无向图?
 * 2. 稠密图 or 稀疏图?
 * 3. 边的权重正 or 负?
 *
 * @since 2020-12-10 Thursday 19:12
 */
void shortestPath(int graph[SIZE][SIZE]) {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (graph[i][j] == 0) {
                graph[i][j] = INT_MAX;
            }
            if (i == j) {
                graph[i][j] = 0;
            }
        }
    }
    for (int k = 0; k < SIZE; k++) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (graph[i][k] != INT_MAX && graph[k][j] != INT_MAX &&
                    graph[i][k] + graph[k][j] < graph[i][j]) {
                    graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }
}

int main(int argc, char const *argv[]) {
    int graph[SIZE][SIZE] = {
        {0, 4, 0, 0, 0, 0, 0, 8, 0},  {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},  {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}};

    shortestPath(graph);
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            std::cout << graph[i][j] << " ";
        }
        std::cout << "\n";
    }
}
