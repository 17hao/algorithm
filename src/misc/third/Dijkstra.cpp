#include <iostream>
#include <limits>
#include <queue>
#include <vector>

#include "../tool.h"

#define SIZE 9

/**
 * dijkstra's algorithm
 *
 * @since 2020-12-10 Thursday 13:36
 */
class Dijkstra {
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

   public:
    /**
     * time complexity O(V^2)
     */
    int* shortestPathUseArr(int graph[SIZE][SIZE], int source);

    int shortestPathUseArr(int graph[SIZE][SIZE], int source, int destination);

    /**
     * use priority_queue
     *
     * time complexity O(V + ElogV)
     */
    int* shortestPathUsePriorityQ(int graph[SIZE][SIZE], int source);
};

int* Dijkstra::shortestPathUseArr(int graph[SIZE][SIZE], int source) {
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

class Node {
   public:
    int index;
    int dist;
    Node(int i, int j) : index(i), dist(j) {
    }
};

bool operator>(const Node& node1, const Node& node2) {
    return node1.dist > node2.dist;
}

int* Dijkstra::shortestPathUsePriorityQ(int graph[SIZE][SIZE], int source) {
    std::priority_queue<Node, std::vector<Node>, std::greater<std::vector<Node>::value_type>> queue;
    int* dist = new int[SIZE];
    int* pre = new int[SIZE];
    for (int i = 0; i < SIZE; i++) {
        dist[i] = INT_MAX;
    }
    dist[source] = 0;
    for (int i = 0; i < SIZE; i++) {
        Node node = Node(i, dist[i]);
        queue.push(node);
    }
    while (!queue.empty()) {
        int curNode = queue.top().index;
        queue.pop();
        for (int j = 0; j < SIZE; j++) {
            if (dist[curNode] != INT_MAX && graph[curNode][j] != 0 &&
                dist[curNode] + graph[curNode][j] < dist[j]) {
                dist[j] = dist[curNode] + graph[curNode][j];
                queue.push(Node(j, dist[j]));
            }
        }
    }
    return dist;
}

int Dijkstra::shortestPathUseArr(int graph[SIZE][SIZE], int source, int destination) {
    int* dist = new int[SIZE];
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
        if (visited[destination]) {
            break;
        }
    }
    return dist[destination];
}

int main(int argc, char const* argv[]) {
    Dijkstra alg;
    int graph[SIZE][SIZE] = {
        {0, 4, 0, 0, 0, 0, 0, 8, 0},  {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},  {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    int* res = alg.shortestPathUseArr(graph, 0);
    printNodeDistance(res, SIZE, 0);
    std::cout << "===\n";
    int* _res = alg.shortestPathUsePriorityQ(graph, 0);
    printNodeDistance(_res, SIZE, 0);

    std::cout << "===\n";
    std::cout << "from 0 -> 1: " << alg.shortestPathUseArr(graph, 0, 1) << "\n";
    std::cout << "from 0 -> 3: " << alg.shortestPathUseArr(graph, 0, 3) << "\n";
    std::cout << "from 0 -> 5: " << alg.shortestPathUseArr(graph, 0, 5) << "\n";
}
