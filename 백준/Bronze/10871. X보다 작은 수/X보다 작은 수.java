import java.io.*;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.valueOf(split[0]);
        int X = Integer.valueOf(split[1]);

        arr = new int[N + 1];

        split = br.readLine().split(" ");

        for (int i = 1; i <= split.length; i++) {
            arr[i] = Integer.valueOf(split[i - 1]);
        }

        String answer = "";

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < X) {
                answer += (arr[i] + " ");
            }
        }

        System.out.println(answer);
    }
}