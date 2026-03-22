package ru.kuzdikenov.contest1;



import java.util.Arrays;
import java.util.Scanner;

public class Task9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 0; i < n; i++) {
            int pos = scanner.nextInt();

            a[pos - 1] = 1;
            int o = solve(a);
            res[i + 1] = o;
        }

        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.print(res[res.length - 1]);

    }

    public static int solve(int[] a) {
        int all = 0;
        int now = 0;
        for (int j : a) {
            if (j == 1) {
                now++;
            } else {
                all += now;
                now = 0;
            }
        }

        return all + 1;
    }

}

