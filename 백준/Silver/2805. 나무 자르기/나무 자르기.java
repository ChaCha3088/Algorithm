import java.io.*;
import java.util.Arrays;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int maxValue = 0;
    private static int[] arr;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[N];

        split = br.readLine().split(" ");

        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);

            if (arr[i] >= maxValue) {
                maxValue = arr[i];
            }
        }

        int l = 0;
        int r = maxValue;

        int mid = -1;

        while (l < r) {
            mid = (l + r) / 2;

            long result = calculate(mid);

            if (result < M) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        System.out.println(l - 1);
    }

    private static long calculate(int height) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int diff = arr[i] - height;

            if (diff > 0) {
                sum += diff;
            }

        }

        return sum;
    }
}