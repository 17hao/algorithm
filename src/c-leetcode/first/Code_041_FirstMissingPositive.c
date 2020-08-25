/* first missing positive in array

   @since 2020-8-25 Tuesday 11:28 - 11:55
 */

#include <stdio.h>

void swap(int *nums, int i, int j);

int firstMissingPositive(int *nums, int numsSize)
{
    for (int i = 0; i < numsSize; i++)
    {
        while (nums[i] > 0 && nums[i] <= numsSize && nums[i] != nums[nums[i] - 1])
            swap(nums, i, nums[i] - 1);
    }
    for (int i = 0; i < numsSize; i++)
    {
        if (nums[i] != i + 1)
            return i + 1;
    }
    return numsSize + 1;
}

void swap(int *nums, int i, int j)
{
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

int main(int argc, char const *argv[])
{
    int n1[4] = {3, 4, -1, 1};
    int n2[3] = {1, 2, 0};
    int n3[5] = {7, 8, 9, 11, 12};
    int n4[3] = {1, 3, 4};
    printf("%d\n", firstMissingPositive(n1, 4)); // 2
    printf("%d\n", firstMissingPositive(n2, 3)); // 3
    printf("%d\n", firstMissingPositive(n3, 5)); // 1
    printf("%d\n", firstMissingPositive(n4, 3)); // 2
}
