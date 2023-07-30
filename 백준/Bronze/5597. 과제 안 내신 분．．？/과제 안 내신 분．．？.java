import java.io.*;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[31];

        for (int i = 1; i <= 28; i++) {
            int input = Integer.valueOf(br.readLine());

            arr[input] += 1;
        }

        for (int i = 1; i <= 30; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }

        }
    }
}