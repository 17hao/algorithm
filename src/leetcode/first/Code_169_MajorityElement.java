package leetcode.first;

/**
 * @author 17hao
 * @date 2019-05-03 22:41
 */
public class Code_169_MajorityElement {
    //todo practice again
    private static int majorityElement(int[] arr) {
        int major = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == major) {
                count += 1;
            } else {
                count -= 1;
            }
            if (count == 0) {
                major = arr[i + 1];
            }
        }
        return major;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 5, 3, 3, 3, 5};
        int res = majorityElement(arr);
        System.out.println(res);
    }
}
