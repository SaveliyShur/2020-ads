package ru.mail.polis.ads.part5_SaveliySchur;

import java.util.Scanner;

public class Task3_264 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mas = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((mas[j] != 0) && mas[i] % mas[j] == 0 && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = d[0];
        for (int i = 1; i < n; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        System.out.println(max);
    }
}
