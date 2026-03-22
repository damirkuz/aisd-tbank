package ru.kuzdikenov.contest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task7 {

    // прикол задачи в том, что если мы берём за pivot центральный элемент, и он является максимумом массива,
    // то левый указатель будет идти до него, а правый останется на месте (в конце массива, тк элементов больше pivot нет)
    // и на этапе обмена самый максимум поменяется с концом массива
    // получается, что он разобьёт массив на массив, всего на 1 элемент меньше и максимум
    // надо сделать так, чтобы в центре всегда оказывался максимальный элемент
    // делается так:
    // берем массив [1, 2], добавляем к нему 3 -> [1, 2, 3]
    // теперь ставим 3 в середину -> [1, 3, 2]
    // алгоритм qsort сделает просто обратное действие
    // теперь ставим 4 -> [1, 3, 2, 4] -> [1, 4, 2, 3] и аналогично


    private static int inversions = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = solve(n);

        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(a[a.length - 1]);


    }

    public static int[] solve(int n) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        if (n == 1) {
            return a.stream().mapToInt(Integer::intValue).toArray();
        } else if (n == 2) {
            a.add(2);
            return a.stream().mapToInt(Integer::intValue).toArray();
        }
        a.add(2);

        for (int i = 2; i <= n - 1; i++) {
            a.add(i + 1);
            int rez = a.get(i);
            a.set(i, a.get(i / 2));
            a.set(i / 2, rez);
        }
        return a.stream().mapToInt(Integer::intValue).toArray();
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
