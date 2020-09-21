#include <iostream>
#include <vector>

using std::vector;

/**
 * move zeroes to the last of array
 *
 * @since 2020-9-21 Monday 18:55
 */
class Solution {
   private:
    void swap(vector<int>& nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

   public:
    /* deprecated */
    void _moveZeroes(vector<int>& nums) {
        int zeroIndex = 0x7fffffff;
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (nums[j] == 0) {
                    zeroIndex = j;
                    break;
                }
            }
            if (nums[i] != 0 && zeroIndex < i) {
                swap(nums, zeroIndex, i);
            }
            // for (int a = 0; a < size; a++) {
            //     std::cout << nums[a] << ",";
            // }
            // std::cout << "\n";
        }
    }

    void moveZeroes(vector<int>& nums) {
        int p = 0, size = nums.size();
        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                nums[p++] = nums[i];
            }
        }
        for (int i = p; i < size; i++) {
            nums[i] = 0;
        }
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<int> v1 = {0, 1, 0, 2, 3};
    vector<int> v2 = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
    vector<int> v3 = {1, 2};
    s.moveZeroes(v1);
    for (int i : v1) {
        std::cout << i << ", ";
    }
    std::cout << "\n";

    s.moveZeroes(v2);
    for (int i : v2) {
        std::cout << i << ", ";
    }
    std::cout << "\n";

    s.moveZeroes(v3);
    for (int i : v3) {
        std::cout << i << ", ";
    }
    std::cout << "\n";
}
