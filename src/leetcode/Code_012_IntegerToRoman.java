package leetcode;

import java.util.Scanner;

/**
 * 整数转罗马数字
 *
 * @author sqh
 * @date 2018/12/19
 */
public class Code_012_IntegerToRoman {
	private static Scanner scanner;

	public static String intToRoman(int num) {
		String res = new String();
		return res;
	}

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		String res = intToRoman(num);
		System.out.print("结果是:" + res);
	}
}
