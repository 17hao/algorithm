#include <algorithm>
#include <iostream>
#include <vector>

using std::vector;

/**
 * combination sum 2
 * candidates有重复元素
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * @since 2020-10-28 Wednesday 17:50 - 18:10
 */
class Solution {
    void traceback(vector<vector<int>>& res, vector<int>& tmp, vector<int> candidates, int target, int index) {
        if (target == 0) {
            res.push_back(tmp);
            return;
        }
        for (int i = index; i < candidates.size(); i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int n = candidates[i];
            if (target >= n) {
                tmp.push_back(n);
                traceback(res, tmp, candidates, target - n, i + 1);
                tmp.pop_back();
            }
        }
    }

   public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        std::sort(candidates.begin(), candidates.end());
        vector<vector<int>> res;
        vector<int> tmp;
        traceback(res, tmp, candidates, target, 0);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<int> v1 = {10, 1, 2, 7, 6, 1, 5};
    vector<vector<int>> res1 = s.combinationSum2(v1, 8);
    for (auto v : res1) {
        std::cout << "[";
        for (int i : v) {
            std::cout << i << " ";
        }
        std::cout << "]\n";
    }
    std::cout << "===\n";
    vector<int> v2 = {2, 5, 2, 1, 2};
    vector<vector<int>> res2 = s.combinationSum2(v2, 5);
    for (auto v : res2) {
        std::cout << "[";
        for (int i : v) {
            std::cout << i << " ";
        }
        std::cout << "]\n";
    }
}
