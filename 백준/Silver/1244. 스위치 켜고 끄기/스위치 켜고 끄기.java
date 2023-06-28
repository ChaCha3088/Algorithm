import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] switches = new int[101];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        //입력
        for (int i = 1; i <= N; i++) {
            switches[i] = sc.nextInt();
        }

        int studentNumber = sc.nextInt();

        for (int i = 0; i < studentNumber; i++) {
             int sex = sc.nextInt();
             int number = sc.nextInt();

             if (sex == 1) {
                 man(number);
             } else if (sex == 2) {
                 woman(number);
             }
        }

        //출력
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(switches[i]);

            if (i % 20 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    private static void man(int number) {
        int currentNumber = number;

        while (currentNumber <= N) {
            if (switches[currentNumber] == 1) {
                switches[currentNumber] = 0;
            } else {
                switches[currentNumber] = 1;
            }

            currentNumber += number;
        }
    }

    private static void woman(int number) {
        int up = number;
        int down = number;

        while (up + 1 <= N && down - 1 > 0) {
            if (switches[up + 1] != switches[down - 1]) {
                break;
            }

            up += 1;
            down -= 1;
        }

        for (int i = down; i <= up; i++) {
            if (switches[i] == 1) {
                switches[i] = 0;
            } else {
                switches[i] = 1;
            }
        }
    }
}