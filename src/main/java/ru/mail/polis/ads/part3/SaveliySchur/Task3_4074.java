package ru.mail.polis.ads.part3.SaveliySchur;


import java.io.*;
import java.util.*;

public class Task3_4074 {

    private static int mediana = 0;
    private final static  List<Integer> heapMax = new ArrayList<>(1000000);
    private final static List<Integer> heapMin = new ArrayList<>(1000000);

    private static void insertInMax(int x){
        heapMax.add(x);
        int i = heapMax.size() - 1;
        int parent = (i - 1)/2;
        while (i > 0 && heapMax.get(parent) < heapMax.get(i)){
            Collections.swap(heapMax,i,parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private static void  insertInMin(int x){
        heapMin.add(x);
        int i = heapMin.size() - 1;
        int parent = (i - 1)/2;
        while (i > 0 && heapMin.get(parent) > heapMin.get(i)){
            Collections.swap(heapMin,i,parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private static int extractMax() {
        Collections.swap(heapMax, 0, heapMax.size()-1);
        int max = heapMax.remove(heapMax.size()-1);
        int i = 0;
        int leftChild;
        int rightChild;
        int largestChild;
        for(;;){
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if(leftChild < heapMax.size() && heapMax.get(leftChild) > heapMax.get(largestChild)){
                largestChild = leftChild;
            }

            if(rightChild < heapMax.size() && heapMax.get(rightChild) > heapMax.get(largestChild)){
                largestChild = rightChild;
            }

            if(largestChild == i){
                break;
            }

            Collections.swap(heapMax, i, largestChild);
            i = largestChild;
        }
        return max;
    }

    private static int extractMin() {
        Collections.swap(heapMin, 0, heapMin.size()-1);
        int max = heapMin.remove(heapMin.size()-1);
        int i = 0;
        int leftChild;
        int rightChild;
        int largestChild;
        for(;;){
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if(leftChild < heapMin.size() && heapMin.get(leftChild) < heapMin.get(largestChild)){
                largestChild = leftChild;
            }

            if(rightChild < heapMin.size() && heapMin.get(rightChild) < heapMin.get(largestChild)){
                largestChild = rightChild;
            }

            if(largestChild == i){
                break;
            }

            Collections.swap(heapMin, i, largestChild);
            i = largestChild;
        }
        return max;
    }

    private static void add(int x){
        if(x >= mediana){
            if(heapMin.size() == heapMax.size()){
                insertInMin(x);
                mediana = heapMin.get(0);
            } else if(heapMin.size() < heapMax.size()){
                insertInMin(x);
                if(heapMax.size() == 0){
                    mediana = x;
                    return;
                }
                mediana = (heapMin.get(0) + heapMax.get(0)) / 2;
            } else {
                insertInMax(extractMin());
                insertInMin(x);
                mediana = (heapMin.get(0) + heapMax.get(0)) / 2;
            }
        } else {
            if(heapMax.size() == heapMin.size()){
                insertInMax(x);
                mediana = heapMax.get(0);
            }else if(heapMin.size() > heapMax.size()){
                insertInMax(x);
                if(heapMin.size() == 0){
                    mediana = x;
                    return;
                }
                mediana = (heapMin.get(0) + heapMax.get(0)) / 2;
            } else {
                insertInMin(extractMax());
                insertInMax(x);
                mediana = (heapMin.get(0) + heapMax.get(0)) / 2;
            }
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        final FastScanner scanner = new FastScanner(System.in);
        try (BufferedOutputStream outp = new BufferedOutputStream(System.out)) {
            while (true){
                int x = scanner.nextInt();
                add(x);
                byte[] buffer = (mediana + "\n").getBytes();
                outp.write(buffer,0,buffer.length);
            }
        }catch (Exception ignored){
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
