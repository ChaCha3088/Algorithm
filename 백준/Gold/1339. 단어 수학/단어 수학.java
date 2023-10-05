import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new Integer['Z' - 'A' + 1];
        Arrays.fill(arr, 0);

        for (int n = 1; n <= N; n++) {
            String str = br.readLine();
            int length = str.length();

            for (int i = 0; i < length; i++) {
                arr[str.charAt(length - i - 1) - 'A'] += (int) Math.pow(10, i);
            }
        }

        // 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;
        int multiple = 9;
        int index = 0;
        while (arr[index] > 0) {
            answer += (multiple * arr[index]);

            multiple -= 1;
            index += 1;
        }

        System.out.println(answer);
    }
}