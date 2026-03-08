package ru.kuzdikenov.contest1;

import java.util.Scanner;

public class Task3 {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int low = 1;
        int high = Integer.parseInt(scanner.nextLine());
        while (high - low > 1) {
            int now = (low + high) / 2;
            String symb = query(now);
            if (symb.equals("<")) {
                high = now - 1;
            } else {
                low = now;
            }
        }

        if (high == low) {
            answer(low);
            return;
        }

        String symb = query(high);
        if (symb.equals("<")) {
            answer(low);
        } else {
            answer(high);
        }
    }

    public static String query(int x) {
        System.out.println(x);
        System.out.flush();
        return scanner.nextLine();
    }

    public static void answer(int x) {
        System.out.println("! " + x);
        System.out.flush();
    }

}

