#include <iostream>
#include <vector>

using std::vector;

/**
 * daily temperatures
 *
 * @since 2020-9-20 Sunday 11:30 - 11:55
 */
class Solution {
   public:
    vector<int> dailyTemperatures(vector<int>& t) {
        int size = t.size();
        vector<int> res(size);
        if (size == 0)
            return res;
        res[size - 1] = 0;
        for (int i = size - 2; i >= 0; i--) {
            if (t[i] < t[i + 1]) {
                res[i] = 1;
            } else {
                int j = i + 1;
                if (res[j] == 0) {
                    res[i] = 0;
                    continue;
                }
                while (j <= size - 1 && t[i] > t[j]) {
                    if (res[j] == 0) {
                        break;
                    }
                    j += res[j];
                }
                res[i] = t[j] > t[i] ? j - i : 0;
            }
        }
        return res;
    }
};

int main(int argc, const char* argv[]) {
    Solution s;
    vector<int> t1 = {73, 74, 75, 71, 69, 72, 76, 73};
    // vector<int> t2 = {34,80,80,34,34,80,80,80,80,34};
    vector<int> res = s.dailyTemperatures(t1);
    for (int i : res) {
        std::cout << i << ", ";
    }
}