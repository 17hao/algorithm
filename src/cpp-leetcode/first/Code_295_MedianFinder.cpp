#include <functional>
#include <iostream>
#include <queue>

/**
 * median finder
 *
 * @since 2020-9-18 Friday 15:20 - 16:45
 */
class MedianFinder {
   private:
    std::priority_queue<int, std::vector<int>, std::greater<int>> small;
    std::priority_queue<int> large;

   public:
    void addNum(int num) {
        if (small.size() >= large.size()) {
            small.push(num);
            large.push(small.top());
            small.pop();
        } else {
            large.push(num);
            small.push(large.top());
            large.pop();
        }
    }

    double findMedian() {
        if (small.size() < large.size()) {
            return large.top();
        } else if (small.size() > large.size()) {
            return small.top();
        } else {
            return (large.top() + small.top()) / 2.0;
        }
    }
};

int main(int argc, char const* argv[]) {
    int arr[10];
    for (int i = 0; i < 10; i++) {
        arr[i] = i;
    }
    MedianFinder* obj = new MedianFinder();
    obj->addNum(arr[0]);
    std::cout << obj->findMedian() << std::endl;  // 0
    obj->addNum(arr[1]);
    obj->addNum(arr[2]);
    obj->addNum(arr[3]);
    std::cout << obj->findMedian() << std::endl;  // 1.5
    obj->addNum(arr[4]);
    obj->addNum(arr[5]);
    obj->addNum(arr[6]);
    std::cout << obj->findMedian() << std::endl;  // 3
    obj->addNum(arr[7]);
    obj->addNum(arr[8]);
    obj->addNum(arr[9]);
    std::cout << obj->findMedian() << std::endl;  // 4.5
}
