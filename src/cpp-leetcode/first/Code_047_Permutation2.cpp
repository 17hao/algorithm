#include <algorithm>
#include <cstdbool>
#include <iostream>
#include <vector>
using std::vector;

/**
 * permutation
 * vector might contains duplicates
 *
 * @since 2020-9-13 Sunday 11:36 - 12:03
 */
class Solution {
   public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        if (nums.size() == 0)
            return {{}};
        vector<vector<int>> res;
        vector<int> tmp;
        vector<bool> used(nums.size(), false);
        std::sort(nums.begin(), nums.end());
        backtrack(nums, used, tmp, res);
        return res;
    }

   private:
    void backtrack(vector<int> nums, vector<bool>& used, vector<int>& tmp,
                   vector<vector<int>>& res) {
        if (tmp.size() == nums.size()) {
            res.push_back(tmp);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1])
                continue;
            used[i] = true;
            tmp.push_back(nums[i]);
            backtrack(nums, used, tmp, res);
            used[i] = false;
            tmp.pop_back();
        }
    }
};

int main() {
    Solution s;
    vector<int> nums = {1, 1, 2};
    vector<vector<int>> res = s.permuteUnique(nums);
    for (auto v : res) {
        std::cout << "[";
        for (int i : v) {
            std::cout << i << " ";
        }
        std::cout << "]\n";
    }
}