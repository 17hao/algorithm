class Solution:
    def numIslands(self, grid):
        if len(grid) == 0:
            return 0
        res = 0
        for i in range(len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == '1':
                    self.helper(grid, i, j)
                    res += 1
        return res

    def helper(self, grid, i, j):
        if i >= len(grid) or i < 0 or j >= len(grid[0]) or j < 0 or grid[i][j] != '1':
            return
        grid[i][j] = '2'
        self.helper(grid, i + 1, j)
        self.helper(grid, i, j + 1)
        self.helper(grid, i - 1, j)
        self.helper(grid, i, j - 1)


if __name__ == "__main__":
    grid = [['1', '1', '0'], ['1', '1', '0']]
    print(len(grid))
    print(Solution().numIslands(grid))
