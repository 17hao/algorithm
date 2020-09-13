#include <stdbool.h>

#include <iostream>
#include <queue>
#include <vector>

using std::vector;

/**
 * course schedule
 * 
 * @since 2020-9-13 Sunday 21:20 - 21:54
 */
class Solution {
   public:
    static bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if (prerequisites.size() <= 1)
            return true;
        vector<int> indegree(numCourses);
        vector<vector<int>> adjacency(numCourses);
        std::queue<int> q;
        for (auto v : prerequisites) {
            indegree[v[0]]++;
            adjacency[v[1]].push_back(v[0]);
        }
        for (int i = 0; i < indegree.size(); i++) {
            if (indegree[i] == 0)
                q.push(i);
        }
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            numCourses--;
            for (int next : adjacency[cur]) {
                if (--indegree[next] == 0)
                    q.push(next);
            }
        }
        return numCourses == 0;
    }
};

int main() {
    vector<vector<int>> prerequisites = {{1, 0}, {0, 1}};
    bool res = Solution::canFinish(2, prerequisites);
    std::cout << res << std::endl;
}