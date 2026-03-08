package ru.kuzdikenov.contest1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double c = scanner.nextDouble();

        double low = 0;
        double high = 100000000;
        double diff = Double.MAX_VALUE;
        double x = 0;
        double eps = 0.0000001;
        for (int i = 0; i < 100; i++) {
            x = (low + high) / 2;

            double f = solve(x);
            diff = Math.abs(f - c);

            if (f > c) {
                high = x;
            } else {
                low = x;
            }
        }
//        while (diff > eps) {
//            x = (low + high) / 2;
//
//            double f = solve(x);
//            diff = Math.abs(f - c);
//
//            if (f > c) {
//                high = x;
//            } else {
//                low = x;
//            }
//        }
        System.out.println(x);
    }

    public static double solve(double x) {
        return x * x + Math.sqrt(x + 1);
    }
}

