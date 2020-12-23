#include <iostream>
#include <vector>
#include <string>
#include <map>

/**
 * 电话号码组合
 *
 * @since 2020-12-22 Tuesday 19:17
 */
class Solution {
    void backtrace(std::vector<std::string>& res, std::map<std::string, std::string> phone, std::string combination, std::string remainingDigits) {
        if (remainingDigits.size() == 0) {
            res.push_back(combination);
            return;
        } else {
            std::string letters = phone[remainingDigits.substr(0, 1)];
            for (int i = 0; i < letters.size(); i++) {
                backtrace(res, phone, combination + letters.substr(i, 1), remainingDigits.substr(1, remainingDigits.size() - 1));
            }
        }
    }

public:
    std::vector<std::string> letterCombinations(std::string digits) {
        std::map<std::string, std::string> phone{{"2", "abc"},{"3", "def"},{"4", "ghi"}, {"5", "jkl"}, {"6", "mno"}, {"7", "pqrs"}, {"8", "tuv"}, {"9", "wxyz"}};
        std::vector<std::string> res;
        if (digits.size() == 0) {
            return res;
        } else {
            backtrace(res, phone, "", digits);
            return res;
        }
    }
};

int main(int argc, const char* argv[]) {
    Solution s;
    std::vector<std::string> res = s.letterCombinations("23");
    std::cout << "res: \n";
    for (auto v : res) {
        std::cout << v << " ";
    }
}
