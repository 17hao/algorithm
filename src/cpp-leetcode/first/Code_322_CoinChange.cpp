#include <algorithm>
#include <iostream>
#include <vector>

/**
 * coin changeg
 *
 * @since 2020-12-7 Monday 19:41 - 19:55
 */
class Solution {
   public:
    int coinChange(std::vector<int>& coins, int amount) {
        int dp[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                dp[i] = std::min(i - coin >= 0 ? dp[i - coin] + 1 : dp[i], dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    std::vector<int> coins1 = {1, 2, 5};
    std::cout << s.coinChange(coins1, 11) << "\n";
    std::vector<int> coins2 = {2};
    std::cout << s.coinChange(coins2, 11) << "\n";
}
