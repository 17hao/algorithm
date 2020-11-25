#include <iostream>

/**
 * add digits
 * 
 * @since 2020-11-25 Wednesday 16:14
 */
class Solution {
   public:
    int addDigits(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
};

int main(int argc, char const *argv[]) {
    Solution s;
    std::cout << s.addDigits(0) << "\n";
    std::cout << s.addDigits(38) << "\n";
}
