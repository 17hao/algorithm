#include <stdlib.h>

#include <iostream>
#include <vector>

#include "ListNode.h"

using std::vector;

class List {
   public:
    static ListNode *linkedList(vector<int> &vec) {
        ListNode *dummy = new ListNode{-1};
        ListNode *cur = dummy;
        for (int i : vec) {
            ListNode *node = new ListNode{i};
            cur->next = node;
            cur = node;
        }
        return dummy->next;
    }

    static void printList(ListNode *head) {
        while (head->next != NULL) {
            std::cout << head->val << "->";
            head = head->next;
        }
        std::cout << head->val << std::endl;
    }
};