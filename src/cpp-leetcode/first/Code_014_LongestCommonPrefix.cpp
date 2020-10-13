#include <iostream>
#include <string>
#include <vector>

using std::string;
using std::vector;

/**
 * find longest common prefix
 *
 * @since 2020-10-13 Tuesday 19:33 - 19:56
 */
class Solution {
   public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) {
            return "";
        } else {
            string res = "";
            bool flag = true;
            for (int i = 1; i <= strs[0].size() && flag; i++) {
                string subStr = strs[0].substr(0, i);
                string tmp = subStr.substr(0, subStr.size() - 1);
                for (string s : strs) {
                    if (s.substr(0, i) != subStr) {
                        flag = false;
                        res = tmp;
                        break;
                    } else {
                        res = subStr;
                    }
                }
            }
            return res;
        }
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    string s1 = "flower", s2 = "flow", s3 = "flight";
    vector<string> v = {s1, s2, s3};
    string res = s.longestCommonPrefix(v);
    std::cout << res;
}
