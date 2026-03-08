package ru.kuzdikenov.contest1;

import java.util.Arrays;
import java.util.Scanner;

public class Task7 {

    private static int inversions = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }





    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//
//        qsort(a, 0, a.length - 1);
//
//        System.out.println(Arrays.toString(a));
//        System.out.println(inversions);
//
//
//
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//
//        int left = 0;
//        int right = a.length - 1;
//        boolean ord = true;
//
//        for (int i = 1; i <= n; i++) {
//            if (ord) {
//                a[left] = i;
//                left++;
//            } else {
//                a[right] = i;
//                right--;
//            }
//            ord = !ord;
//        }
//
//        if (n % 2 == 0) {
//            swap(a, left, right);
//        }
//
//        for (int i = 0; i < a.length - 1; i++) {
//            System.out.print(a[i] + " ");
//        }
//        System.out.print(a[a.length - 1]);
//    }

    public static void qsort(int[] a, int left, int right) {

        if (right <= left)
            return;
        int q = a[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (a[i] < q) {
                inversions++;
                ++i;
            }
            while (q < a[j]) {
                inversions++;
                --j;
            }

            if (i <= j) {
                swap(a, i, j);
                ++i;
                --j;
            }
        }
        qsort(a, left, j);
        qsort(a, i, right);
    }

    public static void swap(int[] a, int i,  int j) {
        int rez = a[i];
        a[i] = a[j];
        a[j] = rez;
    }
}
