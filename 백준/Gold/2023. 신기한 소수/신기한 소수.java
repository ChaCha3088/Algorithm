import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static String string = "";
    private static int[] first = new int[] {2, 3, 5, 7};
    private static int[] rest = new int[] {1, 3, 7, 9};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        make(0);
    }

    private static void make(int depth) {
        if (depth > 0) {
            int result = Integer.parseInt(string);

            // 성공했으면
            if (isPrime(result)) {
                if (depth == N) {
                    // 출력
                    System.out.println(result);
                    return;
                }

                // 아직 전부 안만들어졌으므로 더 만들어야 함
            }
            // 소수가 아니면
            // 여기서 끝내자
            else {
                return;
            }
        }

        // 첫번째 수일 때
        if (depth == 0) {
            for (int i = 0; i < first.length; i++) {
                string += first[i];
                make(depth + 1);
                // 맨 뒤 제거
                string = string.substring(0, string.length() - 1);
            }
        }
        // 그 뒤의 수일 때
        else {
            for (int i = 0; i < rest.length; i++) {
                string += rest[i];
                make(depth + 1);
                // 맨 뒤 제거
                string = string.substring(0, string.length() - 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}