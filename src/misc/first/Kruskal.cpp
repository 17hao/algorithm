#include <algorithm>
#include <cstdbool>
#include <iostream>
#include <vector>

struct Edge {
    int src;
    int dst;
    int length;
    Edge(int x, int y, int z) : src(x), dst(y), length(z) {
    }
};

class UnionFind {
   private:
    std::vector<int> uf;  // union-find
   public:
    UnionFind(int size) {
        for (int i = 0; i < size; i++) {
            uf.push_back(i);
        }
    }

    int find(int x) {
        if (uf[x] != x) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }

    bool connected(int x, int y) {
        return find(x) == find(y);
    }

    void unionSet(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        }
        uf[xset] = yset;
    }
};

/**
 * kruskal's algorithm finds a minimum spanning tree of an undirected edge-weighted graph if the graph is connected.
 *
 * @since 2020-9-16 Wednesday 13:35 - 14:30
 */
class Kruskal {
   private:
    UnionFind* uf;
    std::vector<std::vector<int>> adjacencyList;
    std::vector<Edge> edges;

    void buildMembers(std::vector<std::vector<int>> adjacencyMatrix) {
        int asize = adjacencyMatrix.size();
        adjacencyList.reserve(asize);
        uf = new UnionFind(asize);
        for (int i = 0; i < asize - 1; i++) {
            for (int j = i + 1; j < asize; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    adjacencyList[i].push_back(j);
                    edges.push_back(Edge(i, j, adjacencyMatrix[i][j]));
                }
            }
        }
    }

   public:
    /* minimum spanning tree */
    std::vector<Edge> MST(std::vector<std::vector<int>> adjacencyMatrix) {
        Kruskal::buildMembers(adjacencyMatrix);
        std::sort(edges.begin(), edges.end(), [](Edge e1, Edge e2) { return e1.length < e2.length; });
        std::vector<Edge> res;
        for (Edge e : edges) {
            if (!uf->connected(e.src, e.dst)) {
                res.push_back(e);
                uf->unionSet(e.src, e.dst);
            }
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    // [example](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm#Example)
    std::vector<std::vector<int>> adjacencyMatrix = {
        {0, 7, 0, 5, 0, 0, 0},  {7, 0, 8, 9, 7, 0, 0},  {0, 8, 0, 0, 5, 0, 0}, {5, 9, 0, 0, 15, 6, 0},
        {0, 7, 5, 15, 0, 8, 9}, {0, 0, 0, 6, 8, 0, 11}, {0, 0, 0, 0, 9, 11, 0}};
    Kruskal k;
    std::vector<Edge> res = k.MST(adjacencyMatrix);
    for (Edge e : res) {
        std::cout << e.src << "->" << e.dst << " = " << e.length << std::endl;
    }
}
