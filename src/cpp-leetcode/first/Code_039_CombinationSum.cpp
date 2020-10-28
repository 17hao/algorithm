#include <iostream>
#include <vector>

using std::vector;

/**
 * combination sum
 * 无重复元素的数组 candidates
 * candidates 中的数字可以无限制重复被选取
 *
 * @since 2020-10-28 Wednesday 17:37 - 17:50
 */
class Solution {
    void traceback(vector<vector<int>>& res, vector<int>& tmp, vector<int> candidates, int target, int index) {
        if (target == 0) {
            res.push_back(tmp);
            return;
        }
        for (int i = index; i < candidates.size(); i++) {
            if (target >= candidates[i]) {
                tmp.push_back(candidates[i]);
                traceback(res, tmp, candidates, target - candidates[i], i);
                tmp.pop_back();
            }
        }
    }

   public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> tmp;
        traceback(res, tmp, candidates, target, 0);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<int> v1 = {2, 3, 5};
    vector<vector<int>> res1 = s.combinationSum(v1, 8);
    for (auto v : res1) {
        std::cout << "[";
        for (int i : v) {
            std::cout << i << " ";
        }
        std::cout << "]\n";
    }
    std::cout << "===\n";
    vector<int> v2 = {2, 3, 6, 7};
    vector<vector<int>> res2 = s.combinationSum(v2, 7);
    for (auto v : res2) {
        std::cout << "[";
        for (int i : v) {
            std::cout << i << " ";
        }
        std::cout << "]\n";
    }
}
