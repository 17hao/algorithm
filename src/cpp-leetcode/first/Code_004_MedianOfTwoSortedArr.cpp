#include <algorithm>
#include <iostream>
#include <vector>

using std::vector;

/**
 * find median of 2 sorted arrays
 *
 * @since 2020-9-17 Thursday 16:38
 */
class Solution {
   private:
    int findKth(vector<int> v1, int s1, int e1, vector<int> v2, int s2, int e2, int k) {
        if (k == 1) {
            return std::min(v1[s1], v2[s2]);
        }
        int i1 = std::min(k / 2 - 1, e1);
        int i2 = std::min(k / 2 - 1, e2);
        if (v1[i1] < v2[i2]) {
            return findKth(v1, s1 + i1, e1, v2, s2, e2, k - i1 - 1);
        } else {
            return findKth(v1, s1, e1, v2, s2 + i2, e2, k - i2 - 1);
        }
    }

   public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int size1 = nums1.size(), size2 = nums2.size();
        if (size1 == 0 && size2 == 0) {
            return 0;
        }
        int l = (size1 + size2 + 1) / 2;
        int r = (size1 + size2 + 2) / 2;
        return (findKth(nums1, 0, size1 - 1, nums2, 0, size2 - 1, l) + findKth(nums1, 0, size1 - 1, nums2, 0, size2 - 1, r)) / 2;
    }
};

int main(int argc, char const* argv[]) {
    vector<int> v1 = {1, 3, 5};
    vector<int> v2 = {2, 4, 6, 7};
    vector<int> v3 = {2, 4, 6, 7, 8, 9, 10};
    Solution s;
    double res = s.findMedianSortedArrays(v1, v2);  // 4.0
    std::cout << res << std::endl;
}
