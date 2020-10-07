package ru.mail.polis.ads.part2.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class KStatistic_4827 {

        private int partition(BigInteger[] old, int low, int high){
        BigInteger pivot = old[(low+high)/2];
        int i = low;
        int j = high ;
        while (true){
            while (old[i].compareTo(pivot) < 0) {
                i = i + 1;
            }
            while (old[j].compareTo(pivot) > 0) {
                j = j - 1;
            }
            if (i  >= j){
                return  j;
            }
            BigInteger t = old[i];
            old[i] = old[j];
            old[j] = t;
        }

    }

    private void solve(final FastScanner in, final PrintWriter out) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String numbersString = scanner.nextLine();
        String[] numbersMassiv = numbersString.split(" ");
        BigInteger[] numbers = new BigInteger[numbersMassiv.length];
        for(int i = 0; i < numbersMassiv.length; i++){
            numbers[i] = new BigInteger(numbersMassiv[i]);
        }
        count = numbers.length - count;
        BigInteger answer = findKStat(numbers, count);
        out.println(answer);
    }

    private BigInteger findKStat(BigInteger[] old, int k){
        int left = 0;
        int right = old.length-1;
        while (true){
            int mid = partition(old, left, right);
            if (mid == k){
                return old[mid];
            } else if(k < mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            KStatistic_4827 main = new KStatistic_4827();
            main.solve(in, out);
        }
    }
}
