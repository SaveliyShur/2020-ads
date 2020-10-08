package ru.mail.polis.ads.part2.SaveliySchur;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SimpleSort_3738 {

    public static void merge(int[] array, int left, int mid, int right){
        int[] leftArray = Arrays.copyOfRange(array, left, mid);
        int[] rightArray = Arrays.copyOfRange(array, mid, right);

        int i = 0;
        int j = 0;
        for( int n = left; n < right; n++){
            if(i == mid-left){
                array[n] = rightArray[j];
                j++;
                continue;
            }
            if(j == right-mid){
                array[n] = leftArray[i];
                i++;
                continue;
            }
            if(leftArray[i] < rightArray[j]){
                array[n] = leftArray[i];
                i = i + 1;
            } else{
                array[n] = rightArray[j];
                j = j + 1;
            }
        }
    }

    public static void sort(int[] array, int left, int right){
        if((right-left) == 1){
            return;
        }
        int mid = (right + left) / 2;
        sort(array, left, mid);
        sort(array, mid, right);
        merge(array, left , mid, right);
    }

    private static void solve(final FastScanner in, final PrintWriter out) throws IOException {
        int count = in.nextInt();
        int[] array = new int[count];
        for(int i =0; i < count; i++){
            array[i] = in.nextInt();
        }
        sort(array, 0, count);

        for(int i = 0; i < count; i++){
            out.printf("%d ",array[i]);
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

    public static void main(final String[] arg) throws IOException {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
