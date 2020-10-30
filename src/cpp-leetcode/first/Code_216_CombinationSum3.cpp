#include <iostream>
#include <vector>

using std::vector;

/**
 * combination sum
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * @since 2020-10-30 Friday 10:32 - 10:46
 */
class Solution {
    void traceback(vector<vector<int>>& res, vector<int>& tmp, int target, int count, int index) {
        if (target == 0 && count == 0) {
            res.push_back(tmp);
            return;
        }
        for (int i = index; i < 10; i++) {
            if (target - i >= 0 && count > 0) {
                tmp.push_back(i);
                traceback(res, tmp, target - i, count - 1, i + 1);
                tmp.pop_back();
            }
        }
    }

   public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        vector<int> tmp;
        traceback(res, tmp, n, k, 1);
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<vector<int>> res1 = s.combinationSum3(3, 7);
    vector<vector<int>> res2 = s.combinationSum3(3, 9);
    for (auto v : res1) {
        std::cout << "[";
        for (int i : v) {
            std::cout << i << " ";
        }
        std::cout << "]\n";
    }
    std::cout << "===\n";
    for (auto v : res2) {
        std::cout << "[";
        for (int i : v) {
            std::cout << i << " ";
        }
        std::cout << "]\n";
    }
}
