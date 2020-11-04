#include <iostream>

#define SIZE 7
#define MAX_INT 0x7fffffff

/**
 * Prim's algorithm
 * find minimum spanning tree
 *
 * @since 2020-11-4 Wednesday 23:26
 */
int findMinNode(int dist[SIZE], bool marked[SIZE]) {
    int min = MAX_INT, res = 0;
    for (int i = 0; i < SIZE; i++) {
        if (!marked[i] && dist[i] < MAX_INT) {
            min = dist[i];
            res = i;
        }
    }
    return res;
}

void printNode(int parent[SIZE], int dist[SIZE]) {
    for (int i = 1; i < SIZE; i++) {
        std::cout << (char)('A' + parent[i]) << " -> " << (char)('A' + i) << " = " << dist[i] << "\n";
    }
}

void mst(int graph[SIZE][SIZE]) {
    int parent[SIZE];  // 记录一条路径，从parent[i]到i
    int dist[SIZE];
    bool marked[SIZE];
    for (int i = 0; i < SIZE; i++) {
        dist[i] = MAX_INT;
    }
    dist[0] = 0;
    marked[0] = true;
    for (int count = 0; count < SIZE - 1; count++) {
        int u = findMinNode(dist, marked);
        marked[u] = true;
        for (int v = 0; v < SIZE; v++) {
            if (graph[u][v] && graph[u][v] < dist[v]) {
                parent[v] = u;
                dist[v] = graph[u][v];
            }
        }
    }
    printNode(parent, dist);
}

int main(int argc, char const *argv[]) {
    // [example](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm#Example)
    int graph[SIZE][SIZE] = {{0, 7, 0, 5, 0, 0, 0},  {7, 0, 8, 9, 7, 0, 0},  {0, 8, 0, 0, 5, 0, 0},
                             {5, 9, 0, 0, 15, 6, 0}, {0, 7, 5, 15, 0, 8, 9}, {0, 0, 0, 6, 8, 0, 11},
                             {0, 0, 0, 0, 9, 11, 0}};
    mst(graph);
}
