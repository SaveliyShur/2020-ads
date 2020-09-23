package part1.SaveliyShur;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class Task3 {
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
