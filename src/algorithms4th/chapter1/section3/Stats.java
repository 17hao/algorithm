package algorithms4th.chapter1.section3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();

        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / N;

        StdOut.printf("Mean: %.2f\n", mean);

    }
}
