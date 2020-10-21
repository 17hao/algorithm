#include <iostream>
#include <vector>

using std::vector;

/**
 * find minimum number in rotated array
 *
 * @since 2020-10-21 Wednesday 10:27 - 11:10
 */
class Solution {
    int findPivot(vector<int> v) {
        int size = v.size();
        int l = 0, r = size - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (v[mid] > v[mid + 1]) {
                return mid;
            }
            if (v[mid] < v[l]) {
                r = mid;
            } else if (v[mid] > v[r]) {
                l = mid;
            } else {
                r--;
            }
        }
        return -1;
    }

   public:
    int findMin(vector<int>& nums) {
        int size = nums.size();
        if (size == 0)
            return 0;
        if (size == 1)
            return nums[0];
        int pivot = findPivot(nums);
        return nums[pivot + 1];
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<int> v0 = {1};
    std::cout << s.findMin(v0) << "\n";

    vector<int> v1 = {2, 2, 2, 2, 0, 1};
    std::cout << s.findMin(v1) << "\n";

    vector<int> v2 = {4, 5, -1, 0, 1, 2, 3};
    std::cout << s.findMin(v2) << "\n";

    vector<int> v3 = {2, 2, 2, 2};
    std::cout << s.findMin(v3) << "\n";

    vector<int> v4 = {1, 2, 3, 4};
    std::cout << s.findMin(v4) << "\n";

    vector<int> v5 = {6, 6, 1, 6, 6};
    std::cout << s.findMin(v5) << "\n";
}
