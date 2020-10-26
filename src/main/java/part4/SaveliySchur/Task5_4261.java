package part4.SaveliySchur;

import ru.mail.polis.ads.SolveTemplate;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task5_4261 {

    private static long iniversion = 0;

    public static int[] merge(int[] one, int[] two){
        int max = one.length + two.length;
        int[] result = new int[max];
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
            if(one[i] < two[j]){
                result[n] = one[i];
                i = i + 1;
            } else{
                result[n] = two[j];
                iniversion = iniversion + one.length - i;
                j = j + 1;
            }
        }
        return result;
    }

    public static int[] sort(int[] robots){
        if(robots.length == 1){
            return robots;
        }
        int[] left = sort(Arrays.copyOfRange(robots, 0, robots.length/2));
        int[] right = sort(Arrays.copyOfRange(robots, robots.length/2, robots.length));
        return merge(left, right);
    }
    private static void solve(final FastScanner in, final PrintWriter out) {
        int num = in.nextInt();
        int[] numbers = new int[num];
        for(int i = 0; i < num; i++){
            numbers[i] = in.nextInt();
        }
        sort(numbers);
        System.out.println(iniversion);
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
