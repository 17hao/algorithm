#include <cstdbool>
#include <iostream>

/**
 * union find algorithm
 *
 * @since 2020-9-15 Tuesday 11:30
 */
class UnionFind {
   private:
    int *uf;

   public:
    UnionFind(int size) {
        uf = new int[size];
        for (int i = 0; i < size; i++) {
            uf[i] = i;
        }
    }

    int find(int x);

    bool connected(int x, int y);

    void unionSet(int x, int y);
};

int UnionFind::find(int x) {
    if (uf[x] == x)
        return x;
    else {
        return find(uf[x]);
    }
}

bool UnionFind::connected(int x, int y) {
    return find(x) == find(y);
}

void UnionFind::unionSet(int x, int y) {
    int xset = find(x), yset = find(y);
    if (xset == yset) {
        return;
    }
    xset < yset ? uf[y] = xset : uf[x] = yset;
}

int main(int argc, char const *argv[]) {
    UnionFind u(10);
    u.unionSet(1, 3);
    std::cout << u.find(3) << std::endl;
}
