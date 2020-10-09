package ru.mail.polis.ads.part3.SaveliySchur;

import java.io.*;
import java.util.*;

public class Task2_4039 {

    private static List<Integer> heap = new ArrayList<>();

    public static void insert(int x){
        heap.add(x);
        int i = heap.size() - 1;
        int parent = (i - 1)/2;
        while (i > 0 && heap.get(parent) < heap.get(i)){
            Collections.swap(heap,i,parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public static int extract() {
        Collections.swap(heap, 0, heap.size()-1);
        int max = heap.remove(heap.size()-1);
        int i = 0;
        int leftChild;
        int rightChild;
        int largestChild;
        for(;;){
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if(leftChild < heap.size() && heap.get(leftChild) > heap.get(largestChild)){
                largestChild = leftChild;
            }

            if(rightChild < heap.size() && heap.get(rightChild) > heap.get(largestChild)){
                largestChild = rightChild;
            }

            if(largestChild == i){
                break;
            }

            Collections.swap(heap, i, largestChild);
            i = largestChild;
        }
        return max;
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < count; i++){
            String next = scan.nextLine();
            String[] nextmassiv = next.split(" ");
            if(nextmassiv.length == 2){
                Integer adding = Integer.parseInt(nextmassiv[1]);
                insert(adding);
            } else{
                out.println(extract());
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
            solve(in, out);
        }
    }
}
