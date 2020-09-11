#include <iostream>

using std::string;

/**
 * implement atoi
 *
 * @since 2020-9-11 Friday 17:20 - 18:03
 */
class Solution {
   public:
    int myAtoi(string str) {
        int max = 0x7fffffff;
        int min = 0x80000000;
        long res = 0;
        int i = 0, flag = 1;
        while (str[i] == ' ') {
            i++;
        }
        if (str[i] == '-') {
            flag = -1;
            i++;
        } else if (str[i] == '+') {
            i++;
        }
        for (; i < str.size(); i++) {
            if (res > max || res < min)
                break;
            if (str[i] < '0' || str[i] > '9')
                break;
            res = res * 10 + str[i] - '0';
        }
        res = flag * res;
        if (res > max)
            return max;
        else if (res < min)
            return min;
        else
            return res;
    }
};

int main(int argc, char const *argv[]) {
    Solution s;
    std::cout << s.myAtoi("123") << std::endl;
    std::cout << s.myAtoi("+123") << std::endl;
    std::cout << s.myAtoi("-+123") << std::endl;
    std::cout << s.myAtoi("+-123") << std::endl;
    std::cout << s.myAtoi(" +123") << std::endl;
    std::cout << s.myAtoi("   -42") << std::endl;
    std::cout << s.myAtoi("4193 with words") << std::endl;
    std::cout << s.myAtoi("words and 987") << std::endl;
    std::cout << s.myAtoi("-91283472332") << std::endl;
    std::cout << s.myAtoi("20000000000000000000") << std::endl;
}
