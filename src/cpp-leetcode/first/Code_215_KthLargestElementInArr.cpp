#include <iostream>
#include <vector>

using std::vector;

/**
 * find kth largest element in array
 *
 * @since 2020-10-22 Thursday 16:35 - 17:30
 */
class Solution {
    void swap(vector<int>& v, int i, int j) {
        int tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }

    void siftDown(vector<int>& nums, int start, int end) {
        int root = start;
        while (root * 2 + 1 <= end) {
            int left = root * 2 + 1;
            int right = left + 1;
            int largest = root;
            if (nums[largest] < nums[left]) {
                largest = left;
            }
            if (right <= end && nums[right] > nums[largest]) {
                largest = right;
            }
            if (largest == root) {
                break;
            } else {
                swap(nums, root, largest);
                root = largest;
            }
        }
    }

    void heapify(vector<int>& nums, int count) {
        int start = count - 1;
        while (start >= 0) {
            siftDown(nums, start--, count - 1);
        }
    }

   public:
    int findKthLargest(vector<int>& nums, int k) {
        int size = nums.size();
        heapify(nums, size);
        int end = size - 1;
        for (int i = 0; i < k; i++) {
            swap(nums, 0, end--);
            siftDown(nums, 0, end);
        }
        return nums[end + 1];
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<int> v1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    std::cout << s.findKthLargest(v1, 4) << std::endl;  // 4
    vector<int> v2 = {3, 2, 1, 5, 6, 4};
    std::cout << s.findKthLargest(v2, 2) << std::endl;  // 5
}
