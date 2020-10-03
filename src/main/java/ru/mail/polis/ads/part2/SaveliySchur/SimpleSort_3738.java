package ru.mail.polis.ads.part2.SaveliySchur;

import java.io.*;
import java.util.StringTokenizer;

public class SimpleSort_3738 {

    // Quick sort algorithm
    public static void quicksort(int[] numbers, int low, int high) {
        if (low < high) {
            int dp = partition(numbers, low, high);
            quicksort(numbers, low, dp-1);
            quicksort(numbers, dp+1, high);
        }
    }


    // partition numbers[low] to numbers[high] using numbers[low] as the pivot
    private static int partition(int[] numbers, int low, int high) {
        int pivot = numbers[low];
        int i = low;
        for (int j = low + 1; j <= high; j++)
            if (numbers[j] < pivot) {
                ++i;
                swap(numbers, i, j);
            }
        //end for
        swap(numbers, low, i);
        return i;
    }

    // Exchange list[i] and list[j] values
    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static void solve(final FastScanner in, final PrintWriter out) throws IOException {
        int count = in.nextInt();
        int[] array = new int[count];
        for(int i =0; i < count; i++){
            array[i] = in.nextInt();
        }
        quicksort(array, 0, count-1);
        BufferedOutputStream buffer = new BufferedOutputStream(System.out, count);

        for(int i = 0; i < count-1; i++){
            buffer.write(array[i]);
        }
        buffer.flush();
        buffer.close();
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
