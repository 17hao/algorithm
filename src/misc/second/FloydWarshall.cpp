#include <iostream>

#define L 9
#define MAX_INT 0x7fffffff

/**
 * finding shortest path in a weighted graph
 *
 * @since 2020-11-9 Monday
 */
void shortestPath(int graph[][L]) {
    /* shotest path from i to j */
    for (int k = 0; k < L; k++) {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (graph[i][k] == 0 || graph[k][j] == 0) {
                    continue;
                }
                if ((graph[i][j] == 0 && i != j) || graph[i][k] + graph[k][j] < graph[i][j]) {
                    graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }
}

int main(int argc, char const *argv[]) {
    int graph[L][L] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},  {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2},
                       {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0, 0},
                       {0, 0, 0, 0, 0, 2, 0, 1, 6},  {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}};

    shortestPath(graph);

    for (int i = 0; i < L; i++) {
        for (int j = 0; j < L; j++) {
            std::cout << graph[i][j] << " ";
        }
        std::cout << "\n";
    }
}
