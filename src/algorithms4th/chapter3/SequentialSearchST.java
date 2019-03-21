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
				return xNode.value;
		}
		return null;
	}

	// 判断是否含有某个元素
	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	// 插入key-value pair
	public void put(Key key, Value value) {
		if(key == null) throw new IllegalArgumentException("argument to put() is null");
		if(value == null) {
			delete(key);
			return;
		}
		for(Node xNode = first;xNode!=null;xNode = xNode.next) {
			if(key.equals(xNode.key)) { //如果命中，更新value
				xNode.value = value;
				return;
			}
		}
		first = new Node(key, value, first); //如果未命中，添加key-value pair
		n++;
	}

	// 删除
	public void delete(Key key) {
		if(key == null) throw new IllegalArgumentException("argument to delete() is null");
		first = delete(first,key);
	}

	private Node delete(Node node, Key key) {
		if (key == null)
			return null;
		if (key.equals(node.key)) {
			n--;
			return node.next;
		}
		node.next = delete(node.next, key);
		return node;
	}

	public static void main(String[] args) {
		SequentialSearchST<String,Integer> st = new SequentialSearchST<String,Integer>();
		st.put("one", 1);
		System.out.println(st);
	}
}
