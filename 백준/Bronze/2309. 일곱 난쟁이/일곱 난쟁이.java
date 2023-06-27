import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int K;
    private static StringBuilder sb;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];

        //입력
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        //다 더하기
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int[] resultArr = new int[2];

        //빼면서 찾아보기
        int i = 0;
        boolean iter = true;
        while (iter) {
            for (int j = i + 1; j < arr.length; j++) {
                int newSum = sum;
                int result = newSum - arr[i] - arr[j];
                if (result == 100) {
                    iter = false;
                    resultArr[0] = i;
                    resultArr[1] = j;
                }
            }
            i += 1;
        }


        int[] answerArr = new int[7];
        int idx = 0;

        for (int j = 0; j < arr.length; j++) {
            if (!(j == resultArr[0] || j == resultArr[1])) {
                answerArr[idx] = arr[j];
                idx += 1;
            }
        }

        //정렬
        Arrays.sort(answerArr);

        //출력
        sb = new StringBuilder();

        for (int j = 0; j < answerArr.length; j++) {
            sb.append(answerArr[j]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}