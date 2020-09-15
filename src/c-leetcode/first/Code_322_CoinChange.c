#include <stdio.h>

int coinChange(int *coins, int coinsLen, int amount)
{
    int dp[amount + 1];
    dp[0] = 0;
    for (int i = 1; i <= amount; i++)
    {
        dp[i] = amount + 1;
    }
    for (int i = 1; i <= amount; i++)
    {
        for (int j = 0; j < coinsLen; j++)
        {
            dp[i] = min(i - coins[j] >= 0 ? dp[i - coins[j]] + 1 : amount + 1, dp[i]);
        }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
}

int min(int i, int j)
{
    return i < j ? i : j;
}

int main(int argc, char **argv)
{
    int coins[] = {1, 2};
    printf("%d", coinChange(&coins, 2, 11));
}