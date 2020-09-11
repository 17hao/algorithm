#include <iostream>
#include <vector>

using std::vector;

/**
 * permutation
 *
 * @since 2020-9-11 Friday 15:20 - 16:03
 */
class Solution {
   private:
    void backtrack(vector<int>& nums, vector<int>& tmp, vector<vector<int>>& res) {
        if (tmp.size() == nums.size()) {
            res.push_back(tmp);
            return;
        }
        for (int n : nums) {
            if (std::find(tmp.begin(), tmp.end(), n) != tmp.end()) {
                continue;
            } else {
                tmp.push_back(n);
            }
            backtrack(nums, tmp, res);
            tmp.pop_back();
        }
    }

   public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> tmp;
        if (nums.size() == 0) return {{}};
        backtrack(nums, tmp, res);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<int> vec{1, 2, 3};
    vector<vector<int>> res = s.permute(vec);
    for (auto x : res) {
        std::cout << "[";
        for (auto y : x) {
            std::cout << y << " ";
        }
        std::cout << "]\n";
    }
}