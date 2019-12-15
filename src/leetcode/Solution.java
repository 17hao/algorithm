package leetcode;

import tool.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int getDecimalValue(ListNode head) {
        StringBuilder temp = new StringBuilder();
        while (head != null) {
            temp.append(head.val);
            head = head.next;
        }
        String binary = temp.toString();
        double result = 0;
        for (int i = 0; i < binary.length(); i++) {
            result += (binary.charAt(i) - '0') * Math.pow(2, binary.length() - 1 - i);
        }
        return (int) result;
    }

    public static void main(String[] args) {
//        ListNode head = LinkedListTool.generateList(new int[]{1, 0, 1});
//        System.out.println(getDecimalValue(head));
    }
}
