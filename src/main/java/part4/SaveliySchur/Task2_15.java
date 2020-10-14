package part4.SaveliySchur;

import java.util.Scanner;

public class Task2_15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        int[][] massiv = new int[height][width];
        int[][] semens = new int[height][width];
        for ( int i = height-1; i >=0 ; i--){
            for ( int j = 0; j < width; j++){
                massiv[i][j] = scanner.nextInt();
                semens[i][j] = -1;
            }
        }

        for(int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if(i == 0 && j != 0){
                    semens[i][j] = semens[i][j-1] + massiv[i][j];
                    continue;
                }
                if(i != 0 && j == 0){
                    semens[i][j] = semens[i-1][j] + massiv[i][j];
                    continue;
                }
                if(i == 0){
                    semens[i][j] = massiv[i][j];
                    continue;
                }
                semens[i][j] = Math.max(semens[i-1][j], semens[i][j-1]) + massiv[i][j];
            }
        }

        StringBuilder answer = new StringBuilder();

        int i = height - 1;
        int j = width - 1;
        while (i != 0 || j != 0){
            if(i == 0){
                answer.insert(0, "R");
                j--;
                continue;
            }

            if(j == 0){
                answer.insert(0, "F");
                i--;
                continue;
            }

            if(semens[i-1][j] > semens[i][j-1]){
                answer.insert(0, "F");
                i--;
            } else {
                answer.insert(0, "R");
                j--;
            }
        }

        System.out.println(answer.toString());

    }

}
