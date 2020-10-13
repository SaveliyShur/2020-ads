package ru.mail.polis.ads.part3.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.StringTokenizer;

public class Task4_9016 {

    private static int[] sortedMassiv;

    private static String searh(int x){

        int i = 0;
        int j = sortedMassiv.length - 1;
        while (j - i > 1) {
            int mid = (j+i) / 2;
            if (sortedMassiv[mid] == x) {
                return "YES";
            }
            if (sortedMassiv[mid] < x) {
                i = mid;
            } else {
                j = mid;
            }
        }
        if(sortedMassiv[i] == x || sortedMassiv[j] == x){
            return "YES";
        }
        return "NO";
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int countMassiv = in.nextInt();
        int countRequest = in.nextInt();
        sortedMassiv = new int[countMassiv];
        for ( int i = 0; i < countMassiv; i++){
            sortedMassiv[i] = in.nextInt();
        }
        for(int i = 0; i < countRequest; i ++){
            out.println(searh(in.nextInt()));
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
            solve(in, out);
        }
    }
}
