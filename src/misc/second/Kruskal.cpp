#include <algorithm>
#include <array>
#include <iostream>
#include <vector>

#include "UnionFind.cpp"

#define SIZE 7

/**
 * Kruskal's algorithm
 *
 * @since 2020-12-14 Monday 9:49
 */
class Edge {
   public:
    int src;
    int dst;
    int length;

    Edge(int x, int y, int z): src(x), dst(y), length(z){}
};

class Kruskal {
    UnionFind* uf;
    std::vector<Edge> edges;

    void initializeMembers(std::array<std::array<int, SIZE>, SIZE> graph) {
        uf = new UnionFind(SIZE);
        for (int i = 0; i < SIZE; i++) {
            for (int j = i; j < SIZE; j++) {
                if (graph[i][j] > 0) {
                    edges.push_back(Edge(i, j, graph[i][j]));
                }
            }
        }
    }
    
    void printRes(std::vector<Edge> res) {
        std::cout << "sorce\tdestination\tdistance\n";
        for (Edge e : res) {
            std::cout << char(e.src + 'A') << "\t" << char(e.dst + 'A') << "\t" << e.length << "\n";
        }
    }

   public:
    void mst(std::array<std::array<int, SIZE>, SIZE> graph) {
        initializeMembers(graph);
        std::sort(edges.begin(), edges.end(), [](Edge e1, Edge e2) {return e1.length < e2.length;});
        std::vector<Edge> res;
        for (Edge e : edges) {
            if (!uf->connected(e.src, e.dst)) {
                res.push_back(e);
                uf->unoinSets(e.src, e.dst);
            }
        }
        printRes(res);
    }
};

int main(int argc, const char* argv[]) {
    Kruskal kruskal;
    // [example](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm#Example)
    std::array<std::array<int, SIZE>, SIZE> graph {{
        {{0, 7, 0, 5, 0, 0, 0}},
        {{7, 0, 8, 9, 7, 0, 0}},
        {{0, 8, 0, 0, 5, 0, 0}},
        {{5, 9, 0, 0, 15, 6, 0}}, 
        {{0, 7, 5, 15, 0, 8, 9}}, 
        {{0, 0, 0, 6, 8, 0, 11}},
        {{0, 0, 0, 0, 9, 11, 0}}
    }};
    kruskal.mst(graph);
}