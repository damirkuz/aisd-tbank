package ru.kuzdikenov.contest1;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {

    private static int inversions = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        a = sort(a);

        System.out.println(inversions);
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(a[a.length - 1]);
    }

    public static int[] sort(int[] a) {
        int mid = a.length / 2;
        if (a.length == 1) {
            return a;
        }
        int[] left = sort(Arrays.copyOfRange(a,0, mid));
        int[] right = sort(Arrays.copyOfRange(a, mid, a.length));
        return merge(left, right);
    }

    public static int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int sumLength = a.length + b.length;
        int[] res = new int[sumLength];
        int index = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[index++] = a[i];
                i++;
            } else {
                res[index++] = b[j];
                j++;
                inversions += (a.length - i);
            }
        }

        if (i == a.length) {
            while (j < b.length) {
                res[index++] = b[j++];
            }
        } else {
            while (i < a.length) {
                res[index++] = a[i++];
            }
        }
        return res;
    }
}
