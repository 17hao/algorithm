package archive.basic_class_02;

import static leetcode.tool.CommonTool.*;

public class Code_00_NetherlandsFlag {
    /*
    荷兰旗问题
    指向当前数的指针和大于区域的指针不相撞时
    arr[cur]<num,交换arr[++small]和arr[cur} cur++
    arr[cur]==num,不发生交换,cur++
    arr[cur]>num,交换arr[--big]和arr[cur] cur不变,因为还不确定交换来的数的大小
     */

    /*
    public static int[] partition(int[] arr, int num) {//原始版
        int small = -1;//<num区域的指针
        int big = arr.length;//>num区域的指针
        int cur = 0;//当前指针
        while (cur < big) {
            if (arr[cur] < num) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] == num) {
                cur++;
            } else if (arr[cur] > num) {
                swap(arr, --big, cur);
            }
        }
        return new int[]{small + 1, big};
    }
    */

    /*
    //第二版(经典快排)
    public static int[] partition(int[] arr, int l, int r) {
        int small = l - 1;
        int big = r;
        while (l < big) {
            if (arr[l] < arr[r]) {//左指针对应的数和最右边的数比较
                swap(arr, ++small, l++);
            } else if (arr[l] == arr[r]) {
                l++;
            } else if (arr[l] > arr[r]) {
                swap(arr, --big, l);
            }
        }
        swap(arr, big, r);
        return new int[]{small + 1, big};//最后一个数x和>x区域最左边的一个数交换后big指向=x区域最右边
    }
    */

    /*
    //第三版(基于改良版的快排):随机选取数组中的一个元素
    public static int[] partition(int[] arr, int num) {
        int small = -1;
        int big = arr.length;
        int cur = 0;
        while (cur < big) {
            if (arr[cur] < num) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --big, cur);
            } else {
                cur++;
            }
        }
        return new int[]{small + 1, big - 1};//返回==num区域的左右边界
    }
    */


    //最终版(结合第二版和第三版)
    @SuppressWarnings("all")
    private static int[] partition(int[] arr, int l, int r) {
        int small = l - 1;
        int big = r;
        int seed = l + (int) (Math.random() * (r - l + 1));
        System.out.print("\n" + "arr[" + seed + "]:" + arr[seed] + "\n");
        swap(arr, seed, r);//随机选择数组中的一个数和最后一个数交换
        while (l < big) {
            if (arr[l] < arr[r]) {//和最后一个数作比较,因为最后一个数已经被置换成基准数了
                swap(arr, ++small, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --big, l);
            } else {
                l++;
            }
        }
        swap(arr, big, r);
        return new int[]{small + 1, big};
    }

    public static void main(String[] args) {
        int[] arr1 = generateArray(20, 10);
        int[] tmp = partition(arr1, 0, arr1.length - 1);
        printArray(arr1);
        System.out.print("\n" + tmp[0] + " " + tmp[1]);
    }
}
