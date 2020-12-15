#include <iostream>
#include <vector>

/**
 * union find
 * 
 * @since 2020-12-14 Monday 09:07
 */
class UnionFind {
    std::vector<int> uf;
   
   public:
    UnionFind(int size) {
        for (int i = 0; i < size; i++) {
            uf.push_back(i);
        }
    }

    int find(int x);

    bool connected(int x, int y);

    void unoinSets(int xset, int yset);
};

int UnionFind::find(int x) {
    if (uf[x] != x) {
        return find(uf[x]);
    } else {
        return uf[x];
    }
}

bool UnionFind::connected(int x, int y) {
    return find(x) == find(y);
}

void UnionFind::unoinSets(int x, int y) {
    int xset = find(x), yset = find(y);
    if (xset == yset) {
        return;
    } else {
        uf[yset] = xset;
    }
}