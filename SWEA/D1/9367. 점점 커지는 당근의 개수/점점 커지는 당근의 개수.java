import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] arr;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            boolean atLeastOnce = false;
            int previous = arr[0];
            int diff = -1;
            int count = 2;
            for (int i = 1; i < N; i++) {
                int newDiff = arr[i] - previous;

                if (newDiff > 0 && diff == newDiff) {
                    count += 1;
                }
                else {
                    if (newDiff > 0) {
                        atLeastOnce = true;
                        diff = newDiff;
                        count = 2;
                    }
                    else {
                        diff = -1;
                    }
                }

                previous = arr[i];
            }

            if (!atLeastOnce) {
                count = 1;
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }

        System.out.println(sb);
    }
}