package ru.mail.polis.ads.part2.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.StringTokenizer;

public class BubbleSort_4741 {

    private static void solve(final FastScanner in, final PrintWriter out) {
        int count = in.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < count; i++){
            array[i] = in.nextInt();
        }
        int countSwap = 0;
        for(int i =0; i < count; i++){
            int F = 0;
            for(int j = 0; j < count-1; j++){
                if(array[j] > array[j+1]){
                    int one = array[j];
                    array[j] = array[j+1];
                    array[j+1] = one;
                    F++;
                }
            }
            if(F==0){
                break;
            }
            countSwap += F;
        }
        out.println(countSwap);
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
