import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int N;
    private static StringBuilder sb;
    private static boolean result;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        //입력
        for (int i = 1; i <= N; i++) {
            int[] AArr = new int[5];
            int[] BArr = new int[5];

            int AIter = sc.nextInt();
            for (int j = 1; j <= AIter; j++) {
                int input = sc.nextInt();
                AArr[input] += 1;
            }

            int BIter = sc.nextInt();
            for (int j = 1; j <= BIter; j++) {
                int input = sc.nextInt();
                BArr[input] += 1;
            }

            //출력
            System.out.println(judge(AArr, BArr));
        }
    }

    private static String judge(int[] A, int[] B) {
        boolean AResult = false;
        boolean BResult = false;

        if (A[4] > B[4]) {
            AResult = true;
        } else if (A[4] < B[4]) {
            BResult = true;
        } else {
            if (A[3] > B[3]) {
                AResult = true;
            } else if (A[3] < B[3]) {
                BResult = true;
            } else {
                if (A[2] > B[2]) {
                    AResult = true;
                } else if (A[2] < B[2]) {
                    BResult = true;
                } else {
                    if (A[1] > B[1]) {
                        AResult = true;
                    } else if (A[1] < B[1]) {
                        BResult = true;
                    } else {
                        AResult = true;
                        BResult = true;
                    }
                }
            }
        }

        if (AResult && BResult) {
            return "D";
        } else if (AResult && !BResult) {
            return "A";
        } else if (BResult && !AResult) {
            return "B";
        } else {
            return "D";
        }
    }
}