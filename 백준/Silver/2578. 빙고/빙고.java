import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int count = 0;
    private static int[][] bingo;
    private static boolean done = false;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        bingo = new int[5][5];

        //입력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                 bingo[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 25; i++) {
            count += 1;
            if (delete(sc.nextInt())) {
                checkBingo();
            }
            if (done) {
                System.out.println(count);
                return;
            }
        }
    }

    private static boolean delete(int input) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == input) {
                    bingo[i][j] = 0;
                    return true;
                }
            }
        }
        return false;
    }

    private static void checkBingo() {
        int sum = 0;

        //대각선 확인
        int howManyCrossZero1 = 0;
        int howManyCrossZero2 = 0;

        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) {
                howManyCrossZero1 += 1;
            }
            if (bingo[4 - i][i] == 0) {
                howManyCrossZero2 += 1;
            }
        }

        if (howManyCrossZero1 == 5) {
            sum += 1;
            if (sum == 3) {
                done = true;
                return;
            }
        }
        if (howManyCrossZero2 == 5) {
            sum += 1;
            if (sum == 3) {
                done = true;
                return;
            }
        }

        //가로 세로 확인
        for (int i = 0; i < 5; i++) {
            int howManyZero1 = 0;
            int howManyZero2 = 0;

            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) {
                    howManyZero1 += 1;
                }
                if (bingo[j][i] == 0) {
                    howManyZero2 += 1;
                }
            }
            if (howManyZero1 == 5) {
                sum += 1;
                if (sum == 3) {
                    done = true;
                    return;
                }
            }
            if (howManyZero2 == 5) {
                sum += 1;
                if (sum == 3) {
                    done = true;
                    return;
                }
            }
        }
    }
}