#include <iostream>

void printNodeDistance(int* dist, int len, int source) {
    std::cout << "src\tdest\tdistance\n";
    for (int i = 0; i < len; i++) {
        std::cout << source << "\t" << i << "\t" << dist[i] << "\n";
    }
}