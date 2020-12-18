package ru.mail.polis.ads.part9.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.*;

public class QuickPath_4856 {

    private static void solve(final FastScanner in, final PrintWriter out) {
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(in);
        DijkstraSP sp = new DijkstraSP(digraph);
        if(sp.hasPathTo(digraph.end)) {
            System.out.println(sp.distTo(digraph.end));
            Stack<DirectedEdge> stack = sp.pathTo(digraph.end);
            while (!stack.empty()){
                System.out.print(stack.pop().v+1 + " ");
            }
            System.out.print(digraph.end+1);
        } else {
            System.out.print(-1);
        }
    }

    private static class DijkstraSP{
        private final DirectedEdge[] edgeTo;
        private final int[] distTo;
        private final IndexMinPQ<Integer> pq;

        public DijkstraSP(EdgeWeightedDigraph G) {
            edgeTo = new DirectedEdge[G.V()];
            distTo = new int[G.V()];
            pq = new IndexMinPQ<>(G.V);
            for(int v = 0; v < G.V(); v++){
                distTo[v] = Integer.MAX_VALUE;
            }
            distTo[G.start] = 0;
            pq.insert(G.start, 0);
            while (!pq.isEmpty()){
                relax(G, pq.delMin());
            }
        }

        private void relax(EdgeWeightedDigraph G, int v){
            for(DirectedEdge e : G.adj(v)){
                int w = e.to();
                if(distTo[w] > distTo[v] + e.weight()){
                    distTo[w] = distTo[v] + e.weight();
                    edgeTo[w] = e;
                    if(pq.contains(w)){
                        pq.change(w, distTo[w]);
                    } else {
                        pq.insert(w, distTo[w]);
                    }
                }
            }
        }

        public int distTo(int v){
            return distTo[v];
        }

        public boolean hasPathTo(int v){
            return distTo[v] < Integer.MAX_VALUE;
        }

        public Stack<DirectedEdge> pathTo(int v){
            if(!hasPathTo(v)) return null;
            Stack<DirectedEdge> path = new Stack<>();
            for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
                path.push(e);
            }
            return path;
        }
    }

    private static class EdgeWeightedDigraph{
        private final int V; //Количество вершин
        private int E; //Количество ребер
        private List<DirectedEdge>[] adj;
        private int start;
        private int end;
        public EdgeWeightedDigraph(int V) {
            this.V = V;
            this.E = 0;
            adj = new List[V];
            for(int v = 0; v < V; v++){
                adj[v] = new ArrayList<>();
            }
        }

        public EdgeWeightedDigraph(FastScanner in) {
            this(in.nextInt());
            int E = in.nextInt();
            start = in.nextInt()-1;
            end = in.nextInt()-1;
            for(int i = 0; i < E; i++){
                int v = in.nextInt()-1;
                int w = in.nextInt()-1;
                int weight = in.nextInt();
                DirectedEdge d1 = new DirectedEdge(v,w,weight);
                DirectedEdge d2 = new DirectedEdge(w,v,weight);
                addEdge(d1);
                addEdge(d2);
            }
        }

        public void addEdge(DirectedEdge edge){
            adj[edge.from()].add(edge);
            E++;
        }

        public Iterable<DirectedEdge> adj(int v){
            return adj[v];
        }

        public Iterable<DirectedEdge> edges(){
            List<DirectedEdge> directedEdges = new ArrayList<>();
            for(int v = 0; v < V; v++){
                directedEdges.addAll(adj[v]);
            }
            return directedEdges;
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    private static class DirectedEdge{
        private final int v;
        private final int w;
        private final int weight;

        public DirectedEdge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int weight() {
            return weight;
        }

        public int from(){
            return v;
        }

        public int to(){
            return w;
        }
    }

    private static class IndexMinPQ<Key extends Comparable<Key>>{
        private int N;
        private int[] pq;
        private int[] qp;
        private Key[] keys;

        public IndexMinPQ(int maxN) {
            keys = (Key[]) new Comparable[maxN+1];
            pq = new int[maxN+1];
            qp = new int[maxN+1];
            for(int i = 0; i< maxN+1; i++) qp[i] = -1;
        }

        public boolean isEmpty(){
            return N == 0;
        }

        public boolean contains(int k){
            return  qp[k] != -1;
        }

        public void insert(int k, Key key){
            N++;
            qp[k] = N;
            pq[N] = k;
            keys[k] = key;
            swim(N);
        }

        public Key min(){
            return keys[pq[1]];
        }

        public int delMin(){
            int indexOfMin = pq[1];
            exch(1, N--);
            sink(1);
            keys[pq[N+1]] = null;
            qp[pq[N+1]] = -1;
            return indexOfMin;
        }

        private void exch(int i, int j){
            Key t = keys[i];
            keys[i] = keys[j];
            keys[j] = t;
        }

        private void sink(int k){
            while (2*k <= N){
                int j = 2*k;
                if(j < N && less(j, j+1)) j++;
                if(!less(k,j)) break;
                exch(k,j);
                k=j;
            }
        }

        private boolean less(Comparable v, Comparable w){
            return v.compareTo(w) < 0;
        }

        private void swim(int k){
            while (k > 1 && less(k/2, k)){
                exch(k/2, k);
                k = k/2;
            }
        }

        public void change(int k, Key item){
            keys[k] = item;
            swim(qp[k]);
            sink(qp[k]);
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