package ru.kuzdikenov.contest1;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < k; i++) {
            System.out.println(solve(a, scanner.nextInt()));
        }

    }

    public static int solve(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid = a.length / 2;

        while (high - low > 1) {
            if (x > a[mid]) {
                low = mid;
            } else {
                high = mid;
            }
            mid = (high + low) / 2;
        }
        int dif1 = x - a[low];
        int dif2 = a[high] - x;
        if (dif1 <= dif2) {
            return a[low];
        } else {
            return a[high];
        }
    }
}

