package algorithms4th.chapter3;

public class SequentialSearchST {
    private int n; //number of key-value pairs
    public class Node{
    	private Key key;
    	private Value value;
    	private Node next;
    	public Node(Key key,Value value,Node node) {
			this.key = key;
			this.value = value;
			this.next = node;
		}
    }
    
    //创建空的一个st
    public SequentialSearchST() {};
    
    //返回st的大小
    public int size() {
    	return n;
    }
    
    //判断是否为空
    public boolean isEmpty() {
    	return n == 0;
    }
}
