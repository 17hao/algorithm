#include <iostream>

#define L 100

struct ListNode {
    int val;
    ListNode* next;
    ListNode* pre;
    ListNode(int i) : val(i), next(nullptr), pre(nullptr){};
};

/**
 * stack using linked list or array
 *
 * @since 2020-10-10 Saturday 10:14 - 10:40
 */
class Stack {
    ListNode* dummy;
    ListNode* cur;
    int s;

   public:
    Stack() {
        dummy = new ListNode(-1);
        cur = dummy;
        s = 0;
    }

    void push(int i) {
        ListNode* node = new ListNode(i);
        cur->next = node;
        node->pre = cur;
        cur = node;
        s++;
    }

    int pop() {
        if (s == 0) {
            std::cout << "stack is empty!\n";
            exit(-1);
        }
        ListNode* res = cur;
        ListNode* pre = res->pre;
        pre->next = nullptr;
        cur = pre;
        s--;
        return res->val;
    }

    int size() {
        return s;
    }

    bool empty() {
        return s == 0;
    }
};

class _Stack {
    int* entities;
    int cursor;
    int s;

   public:
    _Stack() {
        entities = new int[L];
        cursor = -1;
        s = 0;
    }

    void push(int i) {
        if (s == L) {
            std::cout << "stack is full!\n";
            exit(-1);
        }
        entities[++cursor] = i;
        s++;
    }

    int pop() {
        if (s == 0) {
            std::cout << "stack is empty!\n";
            exit(-1);
        }
        s--;
        return entities[cursor--];
    }

    int size() {
        return s;
    }

    bool empty() {
        return s == 0;
    }
};

int main(int argc, char const* argv[]) {
    // Stack stack;
    _Stack stack;
    stack.push(1);
    stack.push(2);
    std::cout << stack.pop() << " " << stack.pop() << std::endl;
    // stack.pop(); // stack is empty!
    std::cout << stack.size() << std::endl;
    stack.push(3);
    std::cout << stack.pop() << std::endl;
}
