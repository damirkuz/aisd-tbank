package ru.kuzdikenov.contest1;

import java.util.Arrays;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[26];
        scanner.nextLine();
        String line = scanner.nextLine();

        for (char ch : line.toCharArray()) {
            a[(int) (ch - 'A')] += 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                Character ch = (char) (i + 'A');
                while (a[i] - 2 >= 0) {
                    sb.append(ch);
                    a[i] = a[i] - 2;
                }
            }
        }

        boolean hasCenter = false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                sb.append((char) (i + 'A'));
                hasCenter = true;
                break;
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        String nowString = sb.reverse().toString();

        for (char ch : nowString.toCharArray()) {
            if (hasCenter) {
                hasCenter = false;
                continue;
            }
            sb2.append(ch);
        }

        System.out.println(sb2.toString());
    }
}
