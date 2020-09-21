#include <iostream>
#include <vector>

using std::vector;

/**
 * find unique path
 *
 * @since 2020-9-21 Monday 17:20 - 17:30
 */
class Solution {
   public:
    /*
    状态方程：dp[i][j] i行j列的棋盘的路径数
    状态方程转移：
    初始状态：dp[0][j] = 1 if (g[0][j - 1] != 1)
            dp[i][0] if (g[i - 1][0] != 1)
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] if (g[i][j] == 0) dp[i][j] = 0
    返回值：dp[row - 1][column - 1]
    */
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int row = obstacleGrid.size();
        if (row == 0) {
            return 0;
        }
        int col = obstacleGrid[0].size();
        int dp[row][col];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
};

int main(int argc, char const* argv[]) {
    vector<vector<int>> g1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    vector<vector<int>> g2 = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    vector<vector<int>> g3 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}};
    vector<vector<int>> g4 = {{0, 0, 0}, {1, 0, 0}, {0, 0, 0}};
    Solution s;
    std::cout << s.uniquePathsWithObstacles(g1) << std::endl;
    std::cout << s.uniquePathsWithObstacles(g2) << std::endl;
    std::cout << s.uniquePathsWithObstacles(g3) << std::endl;
    std::cout << s.uniquePathsWithObstacles(g4) << std::endl;
}