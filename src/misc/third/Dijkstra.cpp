#include <iostream>
#include <limits>

#include "../tool.h"

#define SIZE 9
/**
 * dijkstra's algorithm
 *
 * @since 2020-12-10 Thursday 13:36
 */
int findMinDistNode(int dist[SIZE], bool visited[SIZE]) {
    int distance = INT_MAX;
    int res = 0;
    for (int i = 0; i < SIZE; i++) {
        if (!visited[i] && dist[i] < distance) {
            distance = dist[i];
            res = i;
        }
    }
    return res;
}

int* shortestPath(int graph[SIZE][SIZE], int source) {
    int* dist = new int[SIZE];  // the distance between every node and source node
    bool* visited = new bool[SIZE];
    for (int i = 0; i < SIZE; i++) {
        dist[i] = INT_MAX;
        visited[i] = false;
    }
    dist[source] = 0;
    for (int i = 0; i < SIZE; i++) {
        int curNode = findMinDistNode(dist, visited);
        visited[curNode] = true;
        for (int j = 0; j < SIZE; j++) {
            if (!visited[j] && dist[curNode] != INT_MAX && graph[curNode][j] != 0 &&
                dist[curNode] + graph[curNode][j] < dist[j]) {
                dist[j] = dist[curNode] + graph[curNode][j];
            }
        }
    }
    return dist;
}

int main(int argc, char const* argv[]) {
    int graph[SIZE][SIZE] = {
        {0, 4, 0, 0, 0, 0, 0, 8, 0},  {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},  {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    int* res = shortestPath(graph, 0);
    printNodeDistance(res, SIZE, 0);
}
