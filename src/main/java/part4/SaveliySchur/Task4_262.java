package part4.SaveliySchur;

import java.util.Scanner;

public class Task4_262 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count+2];
        int[] money = new int[count+2];
        numbers[0] = 0;
        numbers[count+1] = 0;
        for(int i = 1; i < count+1; i++){
            numbers[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        for(int i = 0; i < count+2; i++){
            if(i < k){
                int max = 0;
                for(int j = 0; j < i; j++){
                    if(numbers[j] > max ){
                        max = numbers[j] ;
                    }
                }
                money[i] = max + numbers[i];
            } else {
                int max = 0;
                for(int j = i-k; j < i; j++){
                    if(numbers[j]  > max ){
                        max = numbers[j] ;
                    }
                }
                money[i] = max + numbers[i];
            }
        }
    }
}
