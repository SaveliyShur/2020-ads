package ru.mail.polis.ads.part5_SaveliySchur;

import java.util.Scanner;

public class Task2_3969 {

    private static int diploms(double a, double w, double h){
        return  (int)Math.floor(a/w) * (int)Math.floor(a/h);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int n = scanner.nextInt();

        double a = Math.max(w, h);
        double b = Math.max(w, h) * n;
        double eps = 0.00001;
        double answer = a;

        while ((b-a) > eps){
            double mid = (a+b) / 2;
            if(diploms(mid, w, h) == n){
                answer = mid;
                break;
            }
            if(diploms(mid, w,h) < n){
                a = mid;
            } else {
                b = mid;
            }
            answer = b;
        }
        if(diploms(Math.floor(answer)-1, w, h) >= n){
            answer= Math.floor(answer)-1;
        } else if(diploms(Math.floor(answer), w, h) >= n){
            answer= Math.floor(answer);
        } else{
            answer = Math.ceil(answer);
        }
        System.out.printf("%.0f\n", answer);

    }
}
