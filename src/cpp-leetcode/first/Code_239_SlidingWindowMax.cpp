#include <deque>
#include <iostream>
#include <vector>

/**
 * max number in sliding window
 *
 * @since 2020-11-25 Wednesday
 */
class Solution {
   public:
    std::vector<int> maxSlidingWindow(std::vector<int>& nums, int k) {
        if (nums.size() < 2)
            return nums;
        std::vector<int> res;
        std::deque<int> queue;
        for (int i = 0; i < nums.size(); i++) {
            while (!queue.empty() && nums[queue.back()] <= nums[i]) {
                queue.pop_back();
            }
            queue.push_back(i);
            if (i - queue.front() >= k) {
                queue.pop_front();
            }
            if (i + 1 >= k) {
                res.push_back(nums[queue.front()]);
            }
        }
        return res;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    std::vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
    std::vector<int> res = s.maxSlidingWindow(nums, 1);
    for (int i : res) {
        std::cout << i << " ";
    }
}
