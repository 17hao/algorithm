package leetcode;

/**
 * 加一
 *
 * @author sqh
 * @date 2018/12/17
 */
public class Code_066_PlusOne {
	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}

	public static void main(String[] args) {
//		int[] arrs = { 9,8,7,6,5,4,3,2,1,0 };
		int[] arrs = { 9, 5, 9 };
		int[] res = plusOne(arrs);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
