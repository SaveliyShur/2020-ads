package ru.mail.polis.ads.part3.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.StringTokenizer;

public class Task1_3737 {

    private static void solve(final FastScanner in, final PrintWriter out) {
        int count = in.nextInt();
        int[] array = new int[count+1];
        array[0] = 0;
        for(int i = 1; i < count+1; i++){
            array[i] = in.nextInt();
        }
        for( int i = 1; i < count+1; i++){
            if(2*i <= count){
                if(! (array[i] <= array[2*i])){
                    out.println("NO");
                    return;
                }
            }
            if(2*i+1 <= count ){
                if(!(array[i] <= array[2*i + 1])){
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");
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
