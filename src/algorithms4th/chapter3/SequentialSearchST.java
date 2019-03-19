package algorithms4th.chapter3;

/*
 * this implementation uses a singly-linked list and sequential search
 */
public class SequentialSearchST<Key, Value> {
	private int n; // number of key-value pairs
	private Node first;

	public class Node {
		private Key key;
		private Value value;
		private Node next;

		public Node(Key key, Value value, Node node) {
			this.key = key;
			this.value = value;
			this.next = node;
		}
	}

	// 创建空的一个st
	public SequentialSearchST() {
	};

	// 返回st的大小
	public int size() {
		return n;
	}

	// 判断是否为空
	public boolean isEmpty() {
		return n == 0;
	}

	// 从st中取一个元素
	public Value get(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		for (Node xNode = first; xNode != null; xNode = xNode.next) {
			if (key.equals(xNode.key))
				return key;
		}
		return null;
	}

	// 判断是否含有某个元素
	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}
	
	
}
