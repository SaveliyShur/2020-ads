package ru.mail.polis.ads.part2.SaveliySchur;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MergeSort_4037 {

    class Robot implements Comparable<Robot> {
        private int number;
        private int numberLeft;
        private int numberRight;

        public Robot(int number, int numberLeft, int numberRight) {
            this.number = number;
            this.numberLeft = numberLeft;
            this.numberRight = numberRight;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getNumberLeft() {
            return numberLeft;
        }

        public void setNumberLeft(int numberLeft) {
            this.numberLeft = numberLeft;
        }

        public int getNumberRight() {
            return numberRight;
        }

        public void setNumberRight(int numberRight) {
            this.numberRight = numberRight;
        }


        @Override
        public int compareTo(Robot o) {
            if(o.getNumberLeft() > numberLeft){
                return  -1;
            } else if (o.getNumberLeft() < numberLeft){
                return 1;
            }else {
                return Integer.compare(number, o.getNumber());
            }
        }
    }

    public Robot[] merge(Robot[] one, Robot[] two){
        int max = one.length + two.length;
        Robot[] result = new Robot[max];
        int i = 0;
        int j = 0;
        for( int n = 0; n < max; n++){
            if(i == one.length){
                result[n] = two[j];
                j++;
                continue;
            }
            if(j == two.length){
                result[n] = one[i];
                i++;
                continue;
            }
            if(one[i].compareTo(two[j]) < 0){
                result[n] = one[i];
                i = i + 1;
            } else{
                result[n] = two[j];
                j = j + 1;
            }
        }
        return result;
    }

    public Robot[] sort(Robot[] robots){
        if(robots.length == 1){
            return robots;
        }
        Robot[] left = sort(Arrays.copyOfRange(robots, 0, robots.length/2));
        Robot[] right = sort(Arrays.copyOfRange(robots, robots.length/2, robots.length));
        return merge(left, right);
    }

    private void solve(final FastScanner in, final PrintWriter out) {
        int count = in.nextInt();
        Robot[] robots = new Robot[count];
        for (int i = 0; i < count; i++){
            int numberLeft = in.nextInt();
            int numberRight = in.nextInt();
            Robot robot = new Robot(i+1, numberLeft, numberRight);
            robots[i] = robot;
        }
        Robot[] sorted = sort(robots);
        for(int i = 0; i < count; i++){
            out.printf("%d %d \n", sorted[i].numberLeft, sorted[i].numberRight);
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
            MergeSort_4037 main = new MergeSort_4037();
            main.solve(in, out);
        }
    }
}
