#include <iostream>
#include <map>
#include <vector>

using std::vector;

/**
 * subarray sum equals k
 *
 * @since 2020-9-20 Sunday 14:41  -15:00
 */
class Solution {
   public:
    int subarraySum(vector<int>& nums, int k) {
        std::map<int, int> m;
        m[0] = 1;
        int sum = 0, res = 0;
        for (int n : nums) {
            sum += n;
            if (m.find(sum - k) != m.end()) {
                res += m[sum - k];
            }
            int i = m.find(sum) == m.end() ? 0 : m[sum];
            m[sum] = i + 1;
        }
        return res;
    }
};

int main(int argc, const char* argv[]) {
    vector<int> v = {1, 1, 1};
    Solution s;
    std::cout << s.subarraySum(v, 2);
}