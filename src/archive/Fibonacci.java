package archive;

public class Fibonacci {
    static int fibV1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fibV1(n - 1) + fibV1(n - 2);
    }

    static int fibV2(int n) {
        int[] temp = new int[n + 1];
        return helper(n, temp);
    }

    static int helper(int n, int[] temp) {
        if (n == 1 || n == 2) return 1;
        if (temp[n] > 0) {
            return temp[n];
        }
        temp[n] = helper(n - 1, temp) + helper(n - 2, temp);
        return temp[n];
    }

    static int fibV3(int n) {
        return tailRec(n, 1, 1);
    }

    static int tailRec(int n, int pre1, int pre2) {
        if (n == 1) return pre1;
        else return tailRec(n - 1, pre2, pre1 + pre2);
    }

    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        System.out.println(fibV1(45));
        System.out.println(System.currentTimeMillis() - s1);
        System.out.println("===");
        long s2 = System.currentTimeMillis();
        System.out.println(fibV2(45));
        System.out.println(System.currentTimeMillis() - s2);
        System.out.println("===");
        long s3 = System.currentTimeMillis();
        System.out.println(fibV3(45));
        System.out.println(System.currentTimeMillis() - s3);
    }
}
