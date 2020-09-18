package leetcode.first;

import leetcode.tool.CommonTool;

public class Code_011_ContainerWithMostWater {
    /*
    public static int maxArea(int[] height) {
        int[] arr = new int[height.length * (height.length - 1) / 2];
        int tmp = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int max = height[i] > height[j] ? height[j] : height[i];
                arr[tmp++] = max * (j - i);
            }
        }
        //insertSort(arr);
        quickSort(arr, 0, arr.length - 1);
        return arr[arr.length - 1];
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int[] tmp = partition(arr, left, right);
            quickSort(arr, left, tmp[0] - 1);
            quickSort(arr, tmp[1] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int small = left - 1;
        int big = right;
        while (left < big) {
            if (arr[left] < arr[right]) {
                small += 1;
                int tmp = arr[small];
                arr[small] = arr[left];
                arr[left] = tmp;
                left++;
//                swap(arr,++small,left++);
            } else if (arr[left] > arr[right]) {
                big -= 1;
                int tmp = arr[big];
                arr[big] = arr[left];
                arr[left] = tmp;
//                swap(arr,--big,left);
            } else {
                left++;
            }
        }
        int tmp = arr[big];
        arr[big] = arr[right];
        arr[right] = tmp;
//        swap(arr, right, big);
        return new int[]{small + 1, big};
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    */

    /*
    暴力法,时间复杂度O(n²)
    public static int maxArea(int[] nums) {
        int max = Math.min(nums[0],nums[1]) * (nums[1] - nums[0]);//int max=0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(Math.min(nums[i], nums[j]) * (j - i),max );
            }
        }
        return max;
    }
    */

    //双指针法,时间复杂度O(n)
    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = CommonTool.generatePositiveArray(10, 10);
        int area = maxArea(arr);
        System.out.print(area);
    }
}
