package algorithms4th.chapter3;

/**
 * 基于数组的二分查找
 *
 * @author sqh
 * @date 2019/03/21
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] values;
	private int N = 0;

	public BinarySearchST() {
		this(INIT_CAPACITY);
	}

	public BinarySearchST(int initCapacity) {
		// TODO Auto-generated constructor stub
		keys = (Key[]) new Comparable[initCapacity];
		values = (Value[]) new Object[initCapacity];
	}

	public int siz() {
		return N;
	}

	public int rank(Key key) {
		int lo = 0;
		int hi = N - 1;
		while (lo <= hi) {
			int mid = (hi - lo) / 2;
			if (key.compareTo(keys[mid]) < 0) {
				hi = mid - 1;
			} else if (key.compareTo(keys[mid]) > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}
}
