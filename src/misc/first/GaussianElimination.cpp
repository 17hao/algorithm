#include <cmath>
#include <iomanip>
#include <iostream>
#include <vector>

/**
 * gaussian elimination
 *
 * @since 2020-10-20 Tuesday
 */
int findPivotInColumn(std::vector<std::vector<double>>& matrix, int r, int c) {
    int row = matrix.size(), res = r;
    double pivot = std::abs(matrix[r++][c]);
    while (r < row) {
        if (std::abs(matrix[r][c]) > pivot) {
            res = r;
        }
        r++;
    }
    return res;
}

void gaussianElimination(std::vector<std::vector<double>>& matrix) {
    int row = matrix.size();
    if (row == 0) {
        return;
    }
    int column = matrix[0].size();
    int r = 0, c = 0;
    while (r < row && c < column) {
        int iMax = findPivotInColumn(matrix, r, c);
        if (matrix[iMax][c] == 0) {
            r++;
        } else {
            std::swap(matrix[iMax], matrix[r]);
            for (int i = r + 1; i < row; i++) {
                double ratio = matrix[i][c] / matrix[r][c];
                matrix[i][c] = 0;
                for (int j = c + 1; j < column; j++) {
                    matrix[i][j] = matrix[i][j] - matrix[r][j] * ratio;
                }
            }
            r++;
            c++;
        }
    }
}

int main(int argc, char const* argv[]) {
    /*
    2x + y - z = 8
    -3x - y + 2z = -11
    -2x + y + 2z = -3
    */
    std::vector<std::vector<double>> matrix = {{2, 1, -1, 8}, {-3, -1, 2, -11}, {-2, 1, 2, -3}};
    gaussianElimination(matrix);
    // std::cout.precision(5);
    for (auto row : matrix) {
        for (double i : row) {
            std::cout << std::fixed << std::setprecision(6) << i << "   ";
        }
        std::cout << "\n";
    }
}
