package ru.mail.polis.ads.part2.SaveliySchur;


import java.io.*;
import java.util.*;

public class SlySort_1462 {

    public SlySort_1462(){}

    private static void solve(final FastScanner in, final PrintWriter out) {
        int count = in.nextInt();
        List<Integer> array = new ArrayList();
        for(int i =0; i < count; i++){
            array.add(in.nextInt());
        }
        Comparator<Integer> comparator = (x,y) -> {
            if(x % 10 > y % 10){
                return 1;
            } else if (x % 10 < y % 10){
                return -1;
            } else {
                if(x==y){
                    return 0;
                }
                return x > y ? 1 : -1;
            }
        };
        array.stream()
                .sorted(comparator)
                .forEach(out::println);

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
