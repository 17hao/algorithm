#include <iostream>
#include <set>
#include <vector>

using std::vector;

/**
 * find tou total number of friend circles among all the studnets
 *
 * @since 2020-9-15 Tuesday 13:46 - 14:40
 */
class Solution {
   private:
    vector<int> uf;  // union find

    int find(int x) {
        if (uf[x] == x) {
            return x;
        } else {
            return find(uf[x]);
        }
    }

    void unionSet(int x, int y) {
        int xset = find(x);
        int yset = find(y);
        if (xset == yset) {
            return;
        }
        int size = uf.size();
        for (int i = 0; i < size; i++) {
            if (uf[i] == yset) {
                uf[i] = xset;
            }
        }
    }

   public:
    int findCircleNum(vector<vector<int>>& students) {
        int ssize = students.size();
        if (ssize == 0)
            return 0;
        for (int i = 0; i < ssize; i++) {
            uf.push_back(i);
        }
        for (int i = 0; i < ssize - 1; i++) {
            for (int j = i + 1; j < ssize; j++) {
                if (students[i][j] == 1) {
                    unionSet(i, j);
                }
            }
        }
        int res = 0;
        std::set<int> set;
        for (int i = 0; i < ssize; i++) {
            if (set.find(uf[i]) == set.end()) {
                res++;
                set.insert(uf[i]);
            }
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<vector<int>> students1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    vector<vector<int>> students2 = {{1, 0, 0, 1},  // 0-3
                                     {0, 1, 1, 0},  // 1-2
                                     {0, 1, 1, 1},  // 2-3
                                     {1, 0, 1, 1}};
    std::cout << s.findCircleNum(students1) << std::endl;
    std::cout << s.findCircleNum(students2) << std::endl;
}
