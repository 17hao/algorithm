#include "ListNode.h"
#include <stdlib.h>
#include <stdio.h>

ListNode *linkedlist(int *arr, int length)
{
    ListNode *dummy = malloc(sizeof(ListNode));
    dummy->val = -1;
    ListNode *cur = dummy;
    for (int i = 0; i < length; i++)
    {
        ListNode *node = malloc(sizeof(ListNode));
        node->val = arr[i];
        cur->next = node;
        cur = cur->next;
    }
    return dummy->next;
}

void printList(ListNode *head)
{
    ListNode *cur = head;
    while (cur->next != 0)
    {
        printf("%d->", cur->val);
        cur = cur->next;
    }
    printf("%d\n", cur->val);
}