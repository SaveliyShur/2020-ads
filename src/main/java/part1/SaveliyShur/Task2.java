package part1.SaveliyShur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Task2 {
    private Task2() {
        // Should not be instantiated
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int count = in.nextInt();
        for(int i = 0; i < count; i++){
            String stackString = in.next();
            char[] symbolStack = stackString.toCharArray();
            LinkedList<Character> queue = new LinkedList<>();
            for(Character chark: symbolStack){
                if(Character.isLowerCase(chark)){
                    queue.addFirst(chark);
                } else {
                    queue.addLast(chark);
                }
            }
            char[] answer = new char[symbolStack.length];
            for (int j = 0; j < symbolStack.length; j++){
                answer[j] = queue.pollFirst();
            }
            out.println(String.valueOf(answer));
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
