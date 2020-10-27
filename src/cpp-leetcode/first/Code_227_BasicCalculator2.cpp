#include <iostream>
#include <stack>
#include <string>

using std::string;

/**
 * 不包含括号的加减乘除四则运算
 *
 * @since 2020-10-27 Tuesday 16:30 - 17:12
 */
class Solution {
   public:
    int calculate(string s) {
        int size = s.size();
        if (size == 0) {
            return 0;
        }
        std::stack<int> numbers;
        int res = 0, num = 0;
        char sign = '+';
        for (int i = 0; i < size; i++) {
            char c = s[i];
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            if (((c < '0' || c > '9') && c != ' ') || i == size - 1) {
                switch (sign) {
                    case '+':
                        numbers.push(num);
                        break;
                    case '-':
                        numbers.push(-num);
                        break;
                    case '*': {
                        int m = numbers.top();
                        numbers.pop();
                        numbers.push(m * num);
                        break;
                    }
                    case '/': {
                        int m = numbers.top();
                        numbers.pop();
                        numbers.push(m / num);
                        break;
                    }
                    default:
                        break;
                }
                num = 0;
                sign = c;
            }
        }
        while (!numbers.empty()) {
            res += numbers.top();
            numbers.pop();
        }
        return res;
    }
};

int main(int argc, char const *argv[]) {
    Solution s;
    string s1 = "3+2*2";
    string s2 = " 3/2 ";
    string s3 = " 3+5 / 2 ";
    string s4 = "1-1+1";
    std::cout << s.calculate(s1) << "\n";  // 7
    std::cout << s.calculate(s2) << "\n";  // 1
    std::cout << s.calculate(s3) << "\n";  // 5
    std::cout << s.calculate(s4) << "\n";  // 1
}
