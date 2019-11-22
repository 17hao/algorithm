package archive.basic_class_03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 栈和队列的转换
 *
 * @author sqh
 * @since 2018/12/19
 */
public class Code_02_StackAndQueueConvert {
	// 2个栈实现队列
	public static class TwoStacksQueue {
		private Stack<Integer> pushStack;
		private Stack<Integer> pollStack;

		public TwoStacksQueue() {
			pushStack = new Stack<Integer>();
			pollStack = new Stack<Integer>();
		}

		// 入队列
		public void push(int pushObj) {
			pushStack.push(pushObj);
		}

		// 出队列
		public Integer poll() {
			if (pushStack.isEmpty() && pollStack.isEmpty()) {
				throw new RuntimeException("the queue is empty");
			} else if (pollStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					pollStack.push(pushStack.pop());
				}
			}
			return pollStack.pop();
		}

		// 查看队列第一个元素
		public Integer peek() {
			if (pushStack.isEmpty() && pollStack.isEmpty()) {
				throw new RuntimeException("the queue is empty");
			} else if (pollStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					pollStack.push(pushStack.pop());
				}
			}
			return pollStack.peek();
		}
	}

	// 2个队列实现栈
	public static class TwoQueuesStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		// 入栈
		public void push(int pushObj) {
			queue.add(pushObj);
		}

		// 出栈
		public Integer pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("stack is empty");
			} else {
				while (queue.size() > 1) {
					help.add(queue.poll());
				}
				int res = queue.poll();
				swap();
				return res;
			}
		}

		// 查看栈顶元素
		public Integer peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("stack is empty");
			} else {
				while (queue.size() != 1) {
					help.add(queue.poll());
				}
			}
			int res = queue.poll();
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = queue;
			queue = tmp;
		}
	}
}
