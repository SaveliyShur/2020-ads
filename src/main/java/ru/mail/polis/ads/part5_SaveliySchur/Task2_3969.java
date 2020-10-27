package ru.mail.polis.ads.part5_SaveliySchur;

import java.util.Scanner;

public class Task2_3969 {

    public static long solv() {
        Scanner scanner = new Scanner(System.in);
        long w = scanner.nextLong();
        long h = scanner.nextLong();
        long n = scanner.nextLong();

        long a = Math.max(w, h);
        long b = Math.max(w, h) * n;


        while (a < b){
            long mid = (a+b) / 2;
            long count = (mid/h) * (mid/w);
            if(count >= n){
                b = mid;
            } else {
                a = mid+1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(solv());
    }
}
