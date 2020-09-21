#include <iostream>
#include <string>
#include <vector>

using std::string;
using std::vector;

/**
 * restore ip address
 *
 * @since 2020-9-19 Saturday 20:03
 */
class Solution {
   public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if ((a + b + c + d) == s.length()) {
                            int n1 = std::stoi(s.substr(0, a));
                            int n2 = std::stoi(s.substr(a, b));
                            int n3 = std::stoi(s.substr(a + b, c));
                            int n4 = std::stoi(s.substr(a + b + c, d));
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                string str = std::to_string(n1) + "." + std::to_string(n2) + "." + std::to_string(n3) +
                                             "." + std::to_string(n4);
                                if (str.length() == s.length() + 3) {
                                    res.push_back(str);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
};

int main() {
    Solution s;
    string str = "101023";
    vector<string> res = s.restoreIpAddresses(str);
    for (string s : res) {
        std::cout << s << std::endl;
    }
}