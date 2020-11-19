#include <iostream>
#include <vector>

using std::vector;

/**
 * number of islands
 *
 * @since 2020-11-19 Thursday 19:30 - 19:47
 */
class Solution {
    void dfs(vector<vector<char>>& grid, int row, int col) {
        if (row < 0 || row >= grid.size() || col < 0 || col >= grid[0].size() ||
            grid[row][col] == '0') {
            return;
        }
        if (grid[row][col] == '1') {
            grid[row][col] = '#';
            dfs(grid, row, col + 1);
            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col - 1);
        }
    }

   public:
    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    vector<vector<char>> grid = {{'1', '1', '0', '0', '0'},
                                 {'1', '1', '0', '0', '0'},
                                 {'0', '0', '1', '0', '0'},
                                 {'0', '0', '0', '1', '1'}};
    Solution s;
    std::cout << s.numIslands(grid) << "\n";
}
