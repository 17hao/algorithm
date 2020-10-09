#include <iostream>

#define V 7
#define MAX_INT 0x7fffffff

/**
 * prim's algorithm
 *
 * @since 2020-10-9 Friday 17:10
 */
class Prim {
    int minKey(int key[V], bool marked[V]) {
        int min = MAX_INT, res = 0;
        for (int i = 0; i < V; i++) {
            if (!marked[i] && key[i] < min) {
                min = key[i];
                res = i;
            }
        }
        return res;
    }

    void printNode(int parent[V], int graph[V][V]) {
        for (int i = 1; i < V; i++) {
            std::cout << (char)(parent[i] + 'A') << "->" << (char)(i + 'A') << " = " << graph[i][parent[i]]
                      << std::endl;
        }
    }

   public:
    void mst(int graph[V][V]) {
        int* parent = new int[V];  // 记录最小生成树中边的2个节点 i.e.从parent[i]到i
        int* key = new int[V];     // 记录当前mst中节点到相邻节点的最小距离值
        bool* marked = new bool[V];
        for (int i = 0; i < V; i++) {
            key[i] = MAX_INT;
        }
        key[0] = 0;
        parent[0] = -1;
        /*
         1. 找到距离当前mst中节点值最小的节点u
         2.
         和u相邻节点的距离如果小于key数组（key[i]表示当前mst节点到i节点的最小距离）中的值，则将key数组和parent数组更新
        */
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, marked);
            marked[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] && !marked[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    std::cout << "parent: ";
                    for (int i = 0; i < V; i++) {
                        if (parent[i] == MAX_INT) {
                            std::cout << "inf";
                        } else {
                            std::cout << parent[i] << " ";
                        }
                    }
                    std::cout << std::endl;
                    key[v] = graph[u][v];
                    std::cout << "key: ";
                    for (int i = 0; i < V; i++) {
                        if (key[i] == MAX_INT) {
                            std::cout << "inf ";
                        } else {
                            std::cout << key[i] << " ";
                        }
                    }
                    std::cout << std::endl;
                }
            }
        }
        printNode(parent, graph);
    }
};

int main(int argc, char const* argv[]) {
    // [example](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm#Example)
    int graph[V][V] = {{0, 7, 0, 5, 0, 0, 0},  {7, 0, 8, 9, 7, 0, 0},  {0, 8, 0, 0, 5, 0, 0}, {5, 9, 0, 0, 15, 6, 0},
                       {0, 7, 5, 15, 0, 8, 9}, {0, 0, 0, 6, 8, 0, 11}, {0, 0, 0, 0, 9, 11, 0}};
    Prim alg;
    alg.mst(graph);
}
