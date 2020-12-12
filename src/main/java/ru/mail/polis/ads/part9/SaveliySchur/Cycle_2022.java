package ru.mail.polis.ads.part9.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Cycle_2022 {

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
        Graph graph = new Graph(in);
        Cycle cycle = new Cycle(graph);
        if(!cycle.hasCycle){
            System.out.print("No");
        }
    }

    static class Cycle {
        public boolean[] marked;
        public boolean hasCycle;
        public int numberCycle ;

        public Cycle(Graph G) {
            marked = new boolean[G.V()];
            for (int s = 0; s < G.V(); s++) {
                if (!marked[s]) {
                    dfs(G, s, s, s);
                    marked = new boolean[G.V()];
                }
            }
        }

        private void dfs(Graph G, int v, int u, int head) {
            marked[v] = true;
            for (int w : G.adj(v))
                if (!marked[w]) {
                    dfs(G, w, v, head);
                }
                else if (w != u) {
                    hasCycle= true;
                    if(w == head){
                        numberCycle = head;
                        System.out.println("Yes");
                        System.out.println(head+1);
                        System.exit(0);
                    }
                }
        }

        public int getNumberCycle(){
            return numberCycle;
        }

        public boolean hasCycle() {
            return hasCycle;
        }
    }

    static class Graph {
        private final int V;
        private int E;
        private List<Integer>[] adj;
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
            adj[w].add(v);
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

}
