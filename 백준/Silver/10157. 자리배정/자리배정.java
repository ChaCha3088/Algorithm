import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int C, R, K;
    private static int[][] seats;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        //입력
        C = sc.nextInt();
        R = sc.nextInt();
        K = sc.nextInt();

        if (K > C * R) {
            System.out.println(0);
            return;
        }

        seats = new int[C + 2][R + 2];

        for (int i = 0; i <= C + 1; i++) {
            seats[i][0] = 1;
            seats[i][R + 1] = 1;
        }

        for (int i = 0; i <= R + 1; i++) {
            seats[0][i] = 1;
            seats[C + 1][i] = 1;
        }

        int[] current = {1, 1};
        int mode = 1;
        int currentNumber = 1;
        boolean iter = true;

        while (iter && currentNumber <= C * R) {
            //위
            while (mode == 1 && iter) {
                seats[current[0]][current[1]] = currentNumber;
                currentNumber += 1;
                if (currentNumber > K) {
                    iter = false;
                    break;
                }
                if ((seats[current[0]][current[1] + 1] == 0)) {
                    current[1] += 1;
                } else {
                    mode = 2;
                    current[0] += 1;
                }
            }

            //오른쪽
            while (mode == 2 && iter) {
                seats[current[0]][current[1]] = currentNumber;
                currentNumber += 1;
                if (currentNumber > K) {
                    iter = false;
                    break;
                }
                if ((seats[current[0] + 1][current[1]] == 0)) {
                    current[0] += 1;
                } else {
                    mode = 0;
                    current[1] -= 1;
                }
            }

            //아래
            while (mode == 0 && iter) {
                seats[current[0]][current[1]] = currentNumber;
                currentNumber += 1;
                if (currentNumber > K) {
                    iter = false;
                    break;
                }
                if ((seats[current[0]][current[1] - 1] == 0)) {
                    current[1] -= 1;
                } else {
                    mode = 3;
                    current[0] -= 1;
                }
            }

            //왼쪽
            while (mode == 3 && iter) {
                seats[current[0]][current[1]] = currentNumber;
                currentNumber += 1;
                if (currentNumber > K) {
                    iter = false;
                    break;
                }
                if ((seats[current[0] - 1][current[1]] == 0)) {
                    current[0] -= 1;
                } else {
                    mode = 1;
                    current[1] += 1;
                }
            }
        }

        //출력
        System.out.println(current[0] + " " + current[1]);
    }
}