package leetcode;

public class Code_026_RemoveDuplicates {
    private static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[count] = nums[i];
            } else if (nums[i] != nums[i - 1] && i > 0) {
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 4, 4, 5, 6, 6, 7};
        int count = removeDuplicates(arr);
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
