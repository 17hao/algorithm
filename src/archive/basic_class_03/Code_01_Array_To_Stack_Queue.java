package archive.basic_class_03;

/**
 * 用数组实现栈和队列
 *
 * @author sqh
 * @since 2018/12/19
 */
public class Code_01_Array_To_Stack_Queue {
	public static class ArrayStack {
		private Integer[] arr;
		// 栈当前的长度
		private Integer size;

		// 初始化栈
		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("the init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
		}

		// 查看栈顶元素
		public Integer peek() {
			if (size == 0) {
				return null;
			} else {
				return arr[size - 1];
			}
		}

		// 进栈
		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("the stack is full");
			} else {
				arr[size++] = obj;
			}
		}

		// 出栈
		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("the stack is empty");
			} else {
				return arr[--size];
			}
		}
	}

	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;
		private Integer first;
		private Integer last;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("the init size is less than 0");
			} else {
				arr = new Integer[initSize];
				size = 0;
				first = 0;
				last = 0;
			}
		}

		// 查看队列顶部元素
		public Integer peek() {
			if (size == 0) {
				return null;
			} else {
				return arr[first];
			}
		}

		// 入队列
		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("the queue is full");
			} else {
				arr[last] = obj;
				last = last == arr.length - 1 ? 0 : last + 1;
				size++;
			}
		}

		// 出队列
		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("the queue is empty");
			} else {
				first = first == arr.length - 1 ? 0 : first + 1;
				size--;
				return arr[first];
			}
		}
	}

	public static void main(String[] args) {

	}
}
