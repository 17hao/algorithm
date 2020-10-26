#include <iostream>
#include <stack>
#include <string>
#include <vector>

using std::string;
using std::vector;

/**
 * reverse polish notation
 *
 * @since 2020-10-26 Monday 17:00 - 17:15
 */
class Solution {
   public:
    int evalRPN(vector<string>& tokens) {
        if (tokens.empty()) {
            return 0;
        }
        std::stack<int> stack;
        for (string str : tokens) {
            char c1 = str[0];
            char c2 = str[1];
            if ((c1 >= '0' && c1 <= '9') || (c2 >= '0' && c2 <= '9')) {
                stack.push(std::stoi(str));
            } else {
                int i1 = stack.top();
                stack.pop();
                int i2 = stack.top();
                stack.pop();
                if (c1 == '+') {
                    stack.push(i1 + i2);
                } else if (c1 == '-') {
                    stack.push(i2 - i1);
                } else if (c1 == '*') {
                    stack.push(i1 * i2);
                } else if (c1 == '/') {
                    stack.push(i2 / i1);
                }
            }
        }
        return stack.top();
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    vector<string> v1 = {"2", "1", "+", "3", "*"};
    vector<string> v2 = {"4", "13", "5", "/", "+"};
    vector<string> v3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    std::cout << s.evalRPN(v1) << "\n";  // 9
    std::cout << s.evalRPN(v2) << "\n";  // 6
    std::cout << s.evalRPN(v3) << "\n";  // 22
}
