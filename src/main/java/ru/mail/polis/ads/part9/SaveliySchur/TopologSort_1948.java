package ru.mail.polis.ads.part9.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class TopologSort_1948 {

    private static final Stack<Integer> STACK = new Stack<>();
    //Белый - 0, серый - 1, черный - 2
    private static final byte WHITE = 0;
    private static final byte GREY = 1;
    private static final byte BLACK = 2;
    private static byte[] color;
    private static List<Integer>[] listSmeghnosty;


    private static void dfs(int top){
        if(color[top] == BLACK){
            return;
        }
        color[top] = 1;
        for(Integer child : listSmeghnosty[top]){
            if(color[child] == GREY){
                throw new RuntimeException("Найден цикл");
            }
            if(color[child] == WHITE){
                dfs(child);
            }
        }
        color[top] = BLACK;
        STACK.push(top);
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        listSmeghnosty = new ArrayList[n+1];
        int[] countTop = new int[n+1]; //храним сколько вершин приходят в данную, чтобы узнать с какой стартовать
        for(int i = 0; i < n + 1; i++){
            listSmeghnosty[i] = new ArrayList<>(n);
        }
        //создаем список смежности, не используем ноль
        for(int i = 0; i < m; i++){
            int d = in.nextInt();
            int p = in.nextInt();
            listSmeghnosty[d].add(p);
            countTop[p]++;
        }
        color = new byte[n + 1];
        for(int i = 1; i < n + 1; i++){
            if(countTop[i] == 0){
                try {
                    dfs(i);
                } catch (RuntimeException e){
                    System.out.println(-1);
                    return;
                }
            }
        }
        for(int i = 1; i < n +1; i++){
            if(color[i] != BLACK){
                out.println(-1);
                return;
            }
        }
        System.out.println();
        while (!STACK.empty()){
            System.out.print(STACK.pop() + " ");
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
