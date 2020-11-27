#include <iostream>

/**
 * ugly number
 *
 * @since 2020-11-27 Friday
 */
class Solution {
   public:
    bool isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1 ? true : false;
    }
};

int main(int argc, char const *argv[]) {
    Solution s;
    std::cout << s.isUgly(1) << "\n";
    std::cout << s.isUgly(6) << "\n";
    std::cout << s.isUgly(8) << "\n";
    std::cout << s.isUgly(14) << "\n";
}
