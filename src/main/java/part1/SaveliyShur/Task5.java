package part1.SaveliyShur;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Task5 {
    private Task5() {
        // Should not be instantiated
    }

    static class Queue<T>{
        private LinkedList<T> queue = new LinkedList<>();
        int i = 0;
        public void push(T t){
            i++;
            queue.addLast(t);
            System.out.println("ok");
        }
        public void pop(){
            System.out.println(queue.pollFirst());
            i--;
        }
        public void front(){
            System.out.println(queue.peekFirst());
        }
        public void size(){
            System.out.println(i);
        }
        public void clear(){
            queue.clear();
            i=0;
            System.out.println("ok");
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        Queue<Integer> queue = new Queue<>();
        String komand = in.next();
        while(!komand.equals("exit")){
            switch (komand){
                case("push") : queue.push(in.nextInt()); break;
                case ("pop") : queue.pop(); break;
                case ("front") : queue.front(); break;
                case ("clear") : queue.clear(); break;
                case ("size") : queue.size(); break;
            }
            komand = in.next();
        }
        System.out.println("bye");
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
