import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int K;
    private static StringBuilder sb;
    private static int result;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        int[][] arr = new int[7][2];

        //입력
        for (int i = 1; i <= N; i++) {
            int sex = sc.nextInt();
            int grade = sc.nextInt();

            arr[grade][sex] += 1;
        }

        result = 0;

        //필요한 방 수 계산
        for (int i = 1; i <= 6; i++) {
            if (arr[i][0] % K > 0) {
                result += (arr[i][0] / K + 1);
            } else {
                result += (arr[i][0] / K);
            }

            if (arr[i][1] % K > 0) {
                result += (arr[i][1] / K + 1);
            } else {
                result += (arr[i][1] / K);
            }
        }

        System.out.println(result);
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