package ru.mail.polis.ads.part5_SaveliySchur;

import java.util.Scanner;

public class Task4_991 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();

        if (solver(str1,str2) || solver(str2, str1)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    static boolean solver(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        boolean[][] d = new boolean[n1 + 1][n2 + 1];
        d[0][0] = true;

        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; ++j) {
                char c1 = s2.charAt(j - 1);
                char c2 = s1.charAt(i - 1);
                if (c1 == c2 || c2 == '?') {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    if (c2 == '*') {
                        d[i][j] = d[i - 1][j - 1] || d[i - 1][j] || d[i][j - 1];
                    }
                }
            }
        }
        return d[n1][n2];
    }
}
