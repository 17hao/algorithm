#include <cstdbool>
#include <iostream>
#include <vector>

using std::vector;

/**
 * redundant connections
 *
 * @since 2020-9-15 Tuesday 17:00
 */
class Solution {
   private:
    vector<int> uf;  // union-find

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

   public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int esize = edges.size();
        for (int i = 0; i < esize + 1; i++) {
            uf.push_back(i);
        }
        for (auto e : edges) {
            if (connected(e[0], e[1])) {
                int min = e[0] < e[1] ? e[0] : e[1];
                int max = e[0] < e[1] ? e[1] : e[0];
                return {min, max};
            } else {
                unionSet(e[0], e[1]);
            }
        }
        return {};
    }
};

int main(int argc, char const* argv[]) {
    Solution s1;
    Solution s2;
    Solution s3;
    Solution s4;
    vector<vector<int>> edges1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
    vector<vector<int>> edges2 = {{1, 2}, {1, 3}, {2, 3}};
    vector<vector<int>> edges3 = {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}};
    vector<vector<int>> edges4 = {{3, 7},  {1, 4}, {2, 8}, {1, 6}, {7, 9},
                                  {6, 10}, {1, 7}, {2, 3}, {8, 9}, {5, 9}};
    vector<int> res1 = s1.findRedundantConnection(edges1);
    vector<int> res2 = s2.findRedundantConnection(edges2);
    vector<int> res3 = s3.findRedundantConnection(edges3);
    vector<int> res4 = s4.findRedundantConnection(edges4);
    std::cout << res1[0] << "," << res1[1] << std::endl;
    std::cout << res2[0] << "," << res2[1] << std::endl;
    std::cout << res3[0] << "," << res3[1] << std::endl;
    std::cout << res4[0] << "," << res4[1] << std::endl;
}
