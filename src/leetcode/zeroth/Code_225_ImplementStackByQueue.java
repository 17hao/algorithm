package leetcode.zeroth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 17hao
 * @date 2019-04-26 19:49
 */
public class Code_225_ImplementStackByQueue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}

class MyStack {
    private Queue<Integer> q;
    private int size;

    MyStack() {
        q = new LinkedList<>();
    }

    void push(int x) {
        q.add(x);
        size += 1;
    }

    int pop() {
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) temp.add(q.poll());
        int res = q.remove();
        this.q = temp;
        size -= 1;
        return res;
    }

    int peek() {
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) temp.add(q.remove());
        int res = q.element();
        temp.add(q.remove());
        this.q = temp;
        return res;
    }

    boolean isEmpty() {
        return size == 0;
    }
}
