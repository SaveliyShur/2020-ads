package part4.SaveliySchur;

import java.util.Scanner;

public class Task4_262 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count+2];
        numbers[0] = 0;
        numbers[count+1] = 0;
        for(int i = 1; i < count+1; i++){
            numbers[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        for(int i = 1; i < count+2; i++){
            if(i < k) {
                int max = numbers[0];
                for (int j = 1; j < i; j++){
                    if(numbers[j] > max){
                        max = numbers[j];
                    }
                }
                numbers[i] = numbers[i] + max;
            } else {
                int max = numbers[i-k];
                for (int j = i-k+1; j < i; j++){
                    if(numbers[j] > max){
                        max = numbers[j];
                    }
                }
                numbers[i] = numbers[i] + max;
            }
        }
        System.out.println(numbers[count+1]);
    }
}
