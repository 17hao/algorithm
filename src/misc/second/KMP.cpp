#include <iostream>
#include <string>
#include <vector>

/**
 * KMP algorithm
 *
 * @since 2020-9-22 Wednesday 16:00 - 17:06
 */
class KMP {
   private:
    std::vector<int> buildPmt(std::string str) {
        int size = str.length();
        if (size == -1) {
            return {-1};
        }
        std::vector<int> pmt(size);
        pmt[0] = -1;
        int pos = 2, next = 0;
        while (pos < size) {
            if (str[pos - 1] == str[next]) {
                pmt[pos++] = ++next;
            } else if (next > 0) {
                next = pmt[next];
            } else {
                pmt[pos++] = 0;
            }
        }
        return pmt;
    }

   public:
    int findIndex(std::string s, std::string m) {
        if (s.length() == 0 || m.length() == 0) {
            return -1;
        }
        int ssize = s.length(), msize = m.length();
        std::vector<int> pmt = buildPmt(m);
        int i = 0, j = 0;
        while (i < ssize && j < msize) {
            if (s[i] == m[j]) {
                i++;
                j++;
            } else if (pmt[j] == -1) {
                i++;
            } else {
                j = pmt[j];
            }
        }
        return j == msize ? i - j : -1;
    }
};

int main(int argc, char const *argv[]) {
    KMP kmp;
    std::string s1 = "abababcd";
    std::string s2 = "qwerabc";
    std::string s3 = "zyx";
    std::string s4 = "abcxyz";
    std::string m = "abc";
    std::cout << kmp.findIndex(s1, m) << std::endl;
    std::cout << kmp.findIndex(s2, m) << std::endl;
    std::cout << kmp.findIndex(s3, m) << std::endl;
    std::cout << kmp.findIndex(s4, m) << std::endl;
}
