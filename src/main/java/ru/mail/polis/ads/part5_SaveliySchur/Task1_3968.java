package ru.mail.polis.ads.part5_SaveliySchur;

import java.io.*;
import java.util.Scanner;

public class Task1_3968 {

    private static double func(double x, double c){
        return x*x + Math.sqrt(x) - c;
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String co = scanner.next();
        double c = Double.parseDouble(co);
        double eps = 0.0000001;

        double a = 0;
        double b = c;
        double middle;
        double answer = (b+a)/2;
        while ((b-a) > eps){
            middle = (b+a)/2;
            if(func(middle, c) == 0){
                answer = middle;
                break;
            }
            if(func(a, c) * func(middle, c) < 0){
                b = middle;
            } else{
                a = middle;
            }
            answer = middle;
        }

        System.out.println(answer);
    }



    public static void main(final String[] arg) {
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve();
        }
    }
}
