#include <iostream>
#define SIZE 7
#define INT_MAX 0x7fffffff

/**
 * Prim's algorithm
 *
 * @since 2020-12-12 Sunday 21:04 - 21:30
 */
class Prim {
    int findMinDistNode(int dist[SIZE], bool visited[SIZE]) {
        int min = INT_MAX;
        int res = 0;
        for (int i = 0; i < SIZE; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                res = i;
            }
        }
        return res;
    }

    void printRes(int parent[SIZE], int dist[SIZE]) {
        std::cout << "source\tdestination\tdistance\n";
        for (int i = 1; i < SIZE; i++) {
            std::cout << char(parent[i] + 'A') << "\t" << char(i + 'A') << "\t" << dist[i] << "\n";
        }
    }

   public:
    void mst(int graph[SIZE][SIZE]) {
        int* dist = new int[SIZE]; // 下标为i的节点距离最小生成树的距离
        int* parent = new int[SIZE];
        bool* visited = new bool[SIZE];
        for (int i = 0; i < SIZE; i++) {
            dist[i] = INT_MAX;
        }
        dist[0] = 0;
        for (int i = 0; i < SIZE; i++) {
            int curNode = findMinDistNode(dist, visited);
            visited[curNode] = true;
            for (int j = 0; j < SIZE; j++) {
                if (!visited[j] && graph[curNode][j] > 0 && graph[curNode][j] < dist[j]) {
                    dist[j] = graph[curNode][j];
                    parent[j] = curNode;
                }
            }
        }
        printRes(parent, dist);
    }
};

int main(int argc, const char* argv[]) {
    // [example](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm#Example)
    int graph[SIZE][SIZE] = {{0, 7, 0, 5, 0, 0, 0},  {7, 0, 8, 9, 7, 0, 0},  {0, 8, 0, 0, 5, 0, 0},
                             {5, 9, 0, 0, 15, 6, 0}, {0, 7, 5, 15, 0, 8, 9}, {0, 0, 0, 6, 8, 0, 11},
                             {0, 0, 0, 0, 9, 11, 0}};
    Prim prim;
    prim.mst(graph);
}