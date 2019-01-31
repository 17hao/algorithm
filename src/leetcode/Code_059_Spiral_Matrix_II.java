package leetcode;
//package leetcode;
//
//public class Code_59_Spiral_Matrix_II {
//    public static int[][] generateMatrix(int n) {
//        int[][] arr=new int[n][n];
//        for (int i=0;i<n;i++){
//            arr[0][i]=i+1;
//        }
//        for(int i=0;i<n-1;i++){
//            arr[i+1][n-1]=n+i+1;
//        }
//        for(int i=0;i<){
//            arr[]
//        }
//        return arr;
//    }
//
//
//    /*
//      1, 2, 3
//      8, 9, 4
//      7, 6, 5
//    1 , 2, 3,4
//    12,13,14,5
//    11,16,15,6
//    10, 9, 8,7
//     */
//    public static void main(String[] args) {
//        int n = 4;
//        int[][] arr = generateMatrix(n);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (j == n - 1) {
//                    System.out.print(arr[i][j] + "\n");
//                } else {
//                    System.out.print(arr[i][j] + " ");
//                }
//            }
//        }
//    }
//}
