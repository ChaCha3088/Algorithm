import java.io.*;

public class Main {

    private static Long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램

        int N = Integer.valueOf(br.readLine());

        arr = new Long[N + 2];

        arr[1] = 1L;
        arr[2] = 2L;

        if (N == 1) {
            System.out.println(1);
        }
        else if (N == 2) {
            System.out.println(2);
        }
        else {
            for (int i = 3; i <= N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 10_007L;
            }

            System.out.println(arr[N] % 10_007L);
        }
    }
}