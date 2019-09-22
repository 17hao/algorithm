package nowcoder.basic.section_1;

public class Fibonacci {
    // 0,1,1,2,3,5
    private static int fibonacci(int n) {
        return f(0, 1, n);
    }

    private static int f(int pre1, int pre2, int n) {
        if (n == 0) return pre1;
        else return f(pre2, pre1 + pre2, --n);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(fibonacci(i));
        }
    }
}
