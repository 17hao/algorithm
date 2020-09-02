/* 
longest increasing subsequence

状态方程定义：dp[i]表示下标为i的元素最长子序列
状态方程转移：dp[j] = if(nums[j] > nums[i]) max(1+dp[i], dp[j]), j = i + 1
初始值：dp[i] = 1
返回值：dp数组中的最大值

@since 2020-9-1 Tuesday 19:12
@update 2020-9-2 Wednesday
*/

#include <stdio.h>

int max(int i, int j);

int lengthOfLIS(int *nums, int numsSize)
{
    if (numsSize == 0)
        return 0;
    int dp[numsSize];
    for (int i = 0; i < numsSize; i++)
        dp[i] = 1;
    for (int i = 0; i < numsSize; i++)
    {
        for (int j = i + 1; j < numsSize; j++)
        {
            if (nums[j] > nums[i])
                dp[j] = max(1 + dp[i], dp[j]);
        }
    }

    int res = 0;
    for (int i = 0; i < numsSize; i++)
    {
        if (dp[i] > res)
            res = dp[i];
    }
    return res;
}

int max(int i, int j)
{
    return i < j ? j : i;
}

int main(int argc, char const *argv[])
{
    int arr[8] = {10, 9, 2, 5, 3, 7, 101, 18}; // 4
    printf("%d\n", lengthOfLIS(arr, 8));
    // int arr[6] = {10, 9, 2, 5, 3, 4}; // 4
    // printf("%d\n", lengthOfLIS(arr, 6));
}
