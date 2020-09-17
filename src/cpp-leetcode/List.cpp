#include "List.h"

#include <cstdlib>
#include <iostream>
#include <vector>

ListNode *List::linkedList(std::vector<int> &vec) {
    ListNode *dummy = new ListNode{-1};
    ListNode *cur = dummy;
    for (int i : vec) {
        ListNode *node = new ListNode{i};
        cur->next = node;
        cur = node;
    }
    return dummy->next;
}

void List::printList(ListNode *head) {
    if (head == nullptr) {
        std::cout << "null list\n";
        return;
    }
    while (head->next != NULL) {
        std::cout << head->val << "->";
        head = head->next;
    }
    std::cout << head->val << std::endl;
}