#include <cstdbool>
#include <iostream>
#include <vector>

/**
 * union find algorithm
 *
 * @since 2020-9-15 Tuesday 11:30
 */
class UnionFind {
   private:
    std::vector<int> uf;

   public:
    UnionFind(int size) {
        for (int i = 0; i < size; i++) {
            uf.push_back(i);
        }
    }

    int find(int x);

    bool connected(int x, int y);

    void unionSet(int x, int y);
};

int UnionFind::find(int x) {
    // better way
    if (uf[x] != x) {
        uf[x] = find(uf[x]);
    }
    return uf[x];
    // if (uf[x] == x)
    //     return x;
    // else {
    //     return find(uf[x]);
    // }
}

bool UnionFind::connected(int x, int y) {
    return find(x) == find(y);
}

void UnionFind::unionSet(int x, int y) {
    int xset = find(x), yset = find(y);
    if (xset == yset) {
        return;
    }
    uf[xset] = yset;
}

int main(int argc, char const *argv[]) {
    UnionFind u(10);
    u.unionSet(1, 3);
    std::cout << u.find(3) << std::endl;
}
