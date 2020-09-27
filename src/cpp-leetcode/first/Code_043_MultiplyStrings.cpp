#include <algorithm>
#include <iostream>
#include <string>

using std::string;

/**
 * multiply strings
 *
 * @since 2020-9-27 Sunday 19:10 - 20:09
 */
class Solution {
    string add(string n1, string n2) {
        string res = "";
        int carry = 0;
        int i = n1.size() - 1, j = n2.size() - 1;
        while (i >= 0 && j >= 0) {
            int sum = n1[i--] - '0' + n2[j--] - '0' + carry;
            carry = sum >= 10 ? 1 : 0;
            res += std::to_string(sum % 10);
        }
        if (i < 0) {
            while (j >= 0) {
                int sum = n2[j--] - '0' + carry;
                carry = sum >= 10 ? 1 : 0;
                res += std::to_string(sum % 10);
            }
        }
        if (j < 0) {
            while (i >= 0) {
                int sum = n1[i--] - '0' + carry;
                carry = sum >= 10 ? 1 : 0;
                res += std::to_string(sum % 10);
            }
        }
        if (carry == 1) {
            res.append("1");
        }
        std::reverse(res.begin(), res.end());
        std::cout << "res: " << res << std::endl;
        return res;
    }

   public:
    string multiply(string n1, string n2) {
        string res = "";
        if (n1.size() == 0 || n2.size() == 0) {
            return res;
        }
        if (n1 == "0" || n2 == "0") {
            return "0";
        }
        for (int i = n1.size() - 1; i >= 0; i--) {
            string tmp = "";
            int m = n1[i] - '0', carry = 0;
            for (int j = n2.size() - 1; j >= 0; j--) {
                int product = m * (n2[j] - '0') + carry;
                carry = product / 10;
                tmp += std::to_string(product % 10);
            }
            if (carry > 0) {
                tmp += std::to_string(carry);
            }
            std::reverse(tmp.begin(), tmp.end());
            for (int k = 0; k < n1.size() - 1 - i; k++) {
                tmp.append("0");
            }
            std::cout << "tmp: " << tmp << std::endl;
            res = add(res, tmp);
        }
        return res;
    }
};

int main(int argc, char const *argv[]) {
    Solution s;
    string s1 = "123", s2 = "456", s3 = "0";
    std::cout << s.multiply(s1, s2) << std::endl;
    std::cout << s.multiply(s1, s3) << std::endl;
}
