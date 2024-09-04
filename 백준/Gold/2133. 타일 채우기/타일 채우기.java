import java.io.*;

class Main {
    private static long[] arr = new long[31];

    public static void main(String[] args) throws IOException {
        arr[0] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= N; i += 2) {
            arr[i] = arr[i - 2] * 3;

            for (int j = i - 4; j >= 0; j -= 2) {
                arr[i] += arr[j] * 2;
            }
        }

        System.out.println(arr[N]);
    }
}