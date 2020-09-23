package part1.SaveliyShur;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Task3 {
    static class Stack<T>{
        ArrayList<T> stack = new ArrayList<>();
        int i = 0;
        public void push(T t){
            stack.add(t);
            i++;
        }

        public T pop(){
            T t = stack.get(i-1);
            stack.remove(i-1);
            i--;
            return t;
        }

        public boolean empty(){
            return stack.isEmpty();
        }
    }


    private Task3() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        String bracers = in.next();
        char[] bracersMassiv = bracers.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char symbol : bracersMassiv){
            if(symbol == '('){
                stack.push(symbol);
            } else{
                if(!stack.empty()){
                    stack.pop();
                } else{
                    out.println("NO");
                    return;
                }
            }
        }
        out.println(stack.empty() ? "YES" : "NO");
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
