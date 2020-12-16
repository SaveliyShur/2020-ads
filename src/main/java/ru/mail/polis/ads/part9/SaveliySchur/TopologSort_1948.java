package ru.mail.polis.ads.part9.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.*;

public class TopologSort_1948 {
    private static class ExceptionForsort extends Exception {
    }
    private static final Stack<Integer> STACK = new Stack<>();
    //Белый - 0, серый - 1, черный - 2
    private static final byte WHITE = 0;
    private static final byte GREY = 1;
    private static final byte BLACK = 2;
    private static byte[] color;

    private static void dfs(Graph G, int top) throws ExceptionForsort {
        if(color[top] == BLACK){
            return;
        }
        color[top] = 1;
        for(int child : G.adj(top)){
            if(color[child] == GREY){
                throw new ExceptionForsort();
            }
            if(color[child] == WHITE){
                dfs(G, child);
            }
        }
        color[top] = BLACK;
        STACK.push(top);
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        Graph graph = new Graph(in);
        color = new byte[graph.V];
        try {
            for(int i = 0; i < graph.V; i++){
                if(color[i] == WHITE){
                    dfs(graph, i);
                }
            }
            while (!STACK.empty()){
                System.out.print(STACK.pop()+1 + " ");
            }
        } catch (ExceptionForsort e) {
            System.out.println("-1");
        }
    }

    static class Graph {
        private final int V;
        private int E;
        private final List<Integer>[] adj;
        public Graph(int V){
            this.V = V;
            this.E = 0;
            adj = new List[V];
            for(int v = 0; v < V; v++){
                adj[v] = new ArrayList<>();
            }
        }

        public Graph(FastScanner in){
            this(in.nextInt());
            int E = in.nextInt();
            for(int i = 0; i < E; i++){
                int v = in.nextInt()-1;
                int w = in.nextInt()-1;
                addEdge(v,w);
            }

        }

        public int V(){ return V; }
        public int E(){ return E; }
        public void addEdge(int v, int w){
            adj[v].add(w);
            E++;
        }
        public Iterable<Integer> adj(int v){
            return adj[v];
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
