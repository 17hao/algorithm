#include <algorithm>
#include <iostream>
#include <vector>

using std::vector;

/**
 * minimum path sum
 *
 * @since 2020-9-28 Monday 11:03 - 11:15
 */
class Solution {
   public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.size() == 0) {
            return 0;
        }
        int row = grid.size(), col = grid[0].size();
        int dp[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = std::min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<vector<int>> grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    int res = s.minPathSum(grid);
    std::cout << res << std::endl;
}
