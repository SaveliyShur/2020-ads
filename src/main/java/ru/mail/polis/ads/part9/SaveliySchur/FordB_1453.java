package ru.mail.polis.ads.part9.SaveliySchur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FordB_1453 {

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        Graph graph = new Graph(in);
        for(int k = 0; k < graph.V; k++){
            for(int i = 0; i < graph.V; i++){
                for(int j = 0; j < graph.V; j++){
                    if(graph.adj[i][k] != Integer.MAX_VALUE && graph.adj[k][j] != Integer.MAX_VALUE) {
                        graph.adj[i][j] = Math.min(graph.adj[i][j], graph.adj[i][k] + graph.adj[k][j]);
                    }
                }
            }
        }
        for(int i = 0; i < graph.V; i++){
            if(graph.adj[0][i] == Integer.MAX_VALUE){
                System.out.print(30000 + " ");
            } else {
                System.out.print(graph.adj[0][i] + " ");
            }
        }
    }

    static class Graph {
        private final int V;
        private int E;
        public int[][] adj;

        public Graph(int V){
            this.V = V;
            this.E = 0;
            adj = new int[V][V];
            for(int v = 0; v < V; v++){
                for (int i = 0; i < V; i++){
                    adj[v][i] = Integer.MAX_VALUE;
                    if(v == i){
                        adj[v][i] = 0;
                    }
                }
            }
        }

        public Graph(FastScanner in){
            this(in.nextInt());
            int E = in.nextInt();
            for(int i = 0; i < E; i++){
                int v = in.nextInt()-1;
                int w = in.nextInt()-1;
                int ves = in.nextInt();
                addEdge(v,w, ves);
            }
        }

        public int V(){ return V; }
        public int E(){ return E; }

        public void addEdge(int v, int w, int ves){
            if(v==w){
                adj[v][w] = 0;
                return;
            }
            if(ves < adj[v][w]){
                adj[v][w] = ves;
            }
            E++;
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

}
