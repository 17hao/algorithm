#include <stdbool.h>

#include <iostream>
#include <vector>

#define max(i, j) i < j ? j : i

using std::vector;
/**
 * merge intervals
 *
 * @since 2020-9-11 Friday 16:42 - 17：09
 */
class Solution {
   private:
    static bool compare(vector<int> x, vector<int> y) {
        return x[0] < y[0];
    }

   public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if (intervals.size() == 0) return {};
        std::sort(intervals.begin(), intervals.end(), compare);
        for (int i = 0; i < intervals.size(); i++) {
            int left, right;
            left = intervals[i][0];
            right = intervals[i][1];
            while (i < intervals.size() - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = max(right, intervals[i][1]);
            }
            res.push_back({left, right});
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    // vector<vector<int>> intervals{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    // vector<vector<int>> intervals{{1, 3}};
    vector<vector<int>> intervals{{1, 10}, {2, 3}, {4, 5}};
    vector<vector<int>> res = s.merge(intervals);
    for (auto x : res) {
        std::cout << "[";
        for (int y : x) {
            std::cout << y << " ";
        }
        std::cout << "]\n";
    }
}
