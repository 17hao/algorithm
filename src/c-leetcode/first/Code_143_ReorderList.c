/* reorder linked list
   1 -> 2 -> 3 -> 4 -> 5
   1 -> 5 -> 2 -> 4 -> 3 
   找到中点，反转后半段，交错插入前半段

   gcc Code_143_ReorderList.c ../ListNode.c
   
   @since 2020-8-26 Wednesday 13:45 - 15:37
*/

#include "../ListNode.h"
#include <stdlib.h>

struct ListNode *reverseList(struct ListNode *head);

void reorderList(struct ListNode *head)
{
    if (head == 0)
        return;
    struct ListNode *fast = head, *slow = head;
    while (fast->next != 0 && fast->next->next != 0)
    {
        fast = fast->next->next;
        slow = slow->next;
    }
    // printList(slow->next);
    struct ListNode *half = reverseList(slow->next);
    // printList(half);
    slow->next = 0;
    // printList(head);
    while (half != 0)
    {
        struct ListNode *nextHead = head->next;
        struct ListNode *next = half->next;
        head->next = half;
        half->next = nextHead;
        head = nextHead;
        half = next;
    }
}

struct ListNode *reverseList(struct ListNode *head)
{
    struct ListNode *dummy = malloc(sizeof(struct ListNode)), *cur = head;
    dummy->val = 0;
    dummy->next = 0;
    while (cur != 0)
    {
        struct ListNode *tmpHead = dummy->next;
        struct ListNode *next = cur->next;
        dummy->next = cur;
        cur->next = tmpHead;
        cur = next;
    }
    return dummy->next;
}

int main(int argc, char const *argv[])
{
    int arr[4] = {1, 2, 3, 4};
    ListNode *head = linkedlist(arr, 4);
    reorderList(head);
    printList(head);
}
