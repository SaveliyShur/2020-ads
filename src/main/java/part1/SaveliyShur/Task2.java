package part1.SaveliyShur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Task2 {

    class Node{
        char it;
        Node left;
        Node right;

        public Node(char it, Node left, Node right) {
            this.it = it;
            this.left = left;
            this.right = right;
        }
    }

    //Обходит дерево горизонтально
    private String horizontalCrawl(Node root){
        LinkedList<Node> actualQueue = new LinkedList<>();
        StringBuilder answerString = new StringBuilder("");
        actualQueue.addFirst(root);
        while (actualQueue.size() != 0){
            Node actual = actualQueue.pollFirst();
            if(actual.right != null){
                actualQueue.addLast(actual.right);
            }
            if(actual.left != null){
                actualQueue.addLast(actual.left);
            }
            answerString = answerString.insert(0, actual.it);
        }
        return answerString.toString();
    }



    private void solve(final FastScanner in, final PrintWriter out) {
        int count = in.nextInt();
        for(int i = 0; i < count; i++){
            String stackString = in.next();
            char[] charsInStackString = stackString.toCharArray();
            Stack<Node> stack = new Stack<>();
            for(char symbol : charsInStackString){
                if(Character.isLowerCase(symbol)){
                    stack.push(new Node(symbol, null, null));
                } else {
                    Node left = stack.pop();
                    Node right = stack.pop();
                    Node root = new Node(symbol, left, right);
                    stack.push(root);
                }
            }
            String answer = horizontalCrawl(stack.pop());
            out.println(answer);
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
            Task2 task2 = new Task2();
            task2.solve(in, out);
        }
    }
}
