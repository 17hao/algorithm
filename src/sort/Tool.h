#include <iostream>

void printArr(int* arr, int len) {
    for (int i = 0; i < len; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << "\n";
}