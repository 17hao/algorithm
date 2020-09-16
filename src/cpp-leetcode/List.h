#include <cstddef>
#include <vector>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL){};
};

class List {
   public:
    static ListNode *linkedList(std::vector<int> &vec);

    static void printList(ListNode *head);
};