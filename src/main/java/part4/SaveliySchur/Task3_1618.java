package part4.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.StringTokenizer;

public class Task3_1618 {

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int[] oneString = new int[n];
        for(int i = 0; i < n; i++){
            oneString[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] twoString = new int[m];
        for(int i = 0; i < m; i++){
            twoString[i] = in.nextInt();
        }

        int[][] solver = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            solver[i][0] = 0;
        }
        for(int i = 0; i < m+1; i++){
            solver[0][i] = 0;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(oneString[i] == twoString[j]){
                    solver[i+1][j+1] = solver[i][j] + 1;
                } else{
                    solver[i+1][j+1] = Math.max(solver[i][j+1], solver[i+1][j]);
                }
            }
        }

        out.println(solver[n][m]);

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
