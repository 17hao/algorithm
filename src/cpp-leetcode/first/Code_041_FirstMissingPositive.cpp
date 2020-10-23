#include <iostream>
#include <vector>

using std::vector;

/**
 * find first missing posotive number in array
 *
 * @since 2020-10-23 Friday 16:46
 */
class Solution {
    void swap(vector<int>& nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

   public:
    int firstMissingPositive(vector<int>& nums) {
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            while (nums[i] > 0 && nums[i] < size && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < size; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return size + 1;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<int> v1 = {7, 8, 9, 11, 12};
    vector<int> v2 = {3, 4, -1, 1};
    vector<int> v3 = {1, 2, 0};
    std::cout << s.firstMissingPositive(v1) << "\n";
    std::cout << s.firstMissingPositive(v2) << "\n";
    std::cout << s.firstMissingPositive(v3) << "\n";
}
