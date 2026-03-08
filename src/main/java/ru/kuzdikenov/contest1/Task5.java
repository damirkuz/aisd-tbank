package ru.kuzdikenov.contest1;

import java.util.Scanner;

public class Task5 {
    private static int a;
    private static int b;
    private static int c;
    private static int d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();



        double low = -10000000;
        double high = 10000000;
        double x = 0;

        double left = solve(low);
        double right = solve(high);
        boolean mon = right >= left;

        for (int i = 0; i < 100; i++) {
            x = (low + high) / 2;

            double f = solve(x);

            if (mon) {
                if (f > 0) {
                    high = x;
                } else {
                    low = x;
                }
            } else {
                if (f > 0) {
                    low = x;
                } else {
                    high = x;
                }
            }


        }
        System.out.println(x);
    }

    public static double solve(double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }
}

