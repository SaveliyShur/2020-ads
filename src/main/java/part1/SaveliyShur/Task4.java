package part1.SaveliyShur;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Task4 {

    static class Stack<T> {
        ArrayList<T> stack = new ArrayList<>();
        int i = 0;

        public void push(T t) {
            stack.add(t);
            i++;
            System.out.println("ok");
        }

        public void pop() {
            if(i==0){
                System.out.println("error");
                return;
            }
            T t = stack.get(i - 1);
            stack.remove(i - 1);
            i--;
            System.out.println(t);
        }

        public void back() {
            if(i==0){
                System.out.println("error");
                return;
            }
            System.out.println(stack.get(i - 1));
        }

        public void size() {
            System.out.println(i);
        }

        public void clear() {
            stack.clear();
            i = 0;
            System.out.println("ok");
        }
    }

    private Task4() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        Stack<Integer> stack = new Stack<>();
        String komand = in.next();
        while(!komand.equals("exit")){
            switch (komand){
                case("push") : stack.push(in.nextInt()); break;
                case ("pop") : stack.pop(); break;
                case ("back") : stack.back(); break;
                case ("clear") : stack.clear(); break;
                case ("size") : stack.size(); break;
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
