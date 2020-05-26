//package algorithms4th.chapter_1_Fundamentals.section1;
//
//import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
//
//import java.util.Arrays;
//
//public class BinarySearch {
//    public static int rank(int key, int[] a) {
//        // 传入的数组是有序的
//        int lo = 0;
//        int hi = a.length;
//        while (lo < hi) {
//            // 被查找的键要么不存在，要么必然存在于a[]
//            int mid = (lo + hi) / 2;
//            if (key < a[mid]) {
//                hi = mid - 1;
//            } else if (key > a[mid]) {
//                lo = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        int[] whitelist = In.readInts(args[0]);
//        Arrays.sort(whitelist);
//        while (!StdIn.isEmpty()) {
//            int key = StdIn.readInt();
//            if (rank(key, whitelist) < 0) {
//                StdOut.println(key);
//            }
//        }
//    }
//}
