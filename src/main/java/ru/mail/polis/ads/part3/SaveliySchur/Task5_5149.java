package ru.mail.polis.ads.part3.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.StringTokenizer;

public class Task5_5149 {

    private static int[] coordinates;
    private static int countCow;

    private static int binResearh(){
        int left = 0;
        int right = coordinates[coordinates.length-1] - coordinates[0] + 1;
        while ((right - left)  > 1){
            int mid = (right + left) / 2;
            if(stat(mid)){
                left = mid;
            } else{
                right = mid;
            }
        }
        return left;
    }

    private static boolean stat(int x){
        int stat = 1;
        int ut = 0;
        for(int i = 1; i < coordinates.length; i++){
            if((coordinates[i] - coordinates[ut]) >= x){
                stat++;
                ut = i;
            }
        }
        return stat >= countCow;
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int counStoil = in.nextInt();
        countCow = in.nextInt();
        coordinates = new int[counStoil];
        for(int i = 0; i < counStoil; i++){
            coordinates[i] = in.nextInt();
        }
        out.println(binResearh());
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
