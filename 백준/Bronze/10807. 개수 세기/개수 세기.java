import java.io.*;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        arr = new int[N + 1];

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < split.length; i++) {
            arr[i + 1] = Integer.valueOf(split[i]);
        }

        int v = Integer.valueOf(br.readLine());

        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (v == arr[i]) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}