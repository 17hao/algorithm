package leetcode;

/**
 * 荷兰旗问题
 *
 * @author sqh
 * @date 2018/12/18
 */
public class Code_075_Sort_Colors {
	public static void sortColors(int[] nums) {
		int small = -1, big = nums.length;
		int cur = 0;
		while (cur < big) {
			if (nums[cur] < 1) {
				swap(nums, ++small, cur++);
			} else if (nums[cur] > 1) {
				swap(nums, --big, cur);
			} else {
				cur++;
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 0, 2, 1, 1, 1 };
		sortColors(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
