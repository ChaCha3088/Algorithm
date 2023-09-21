import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, C;
    private static int lastOne;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int n = 1; n <= N; n++) {
            arr[n - 1] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(arr);

        lastOne = arr[arr.length - 1];

        System.out.println(binarySearch());
    }

    private static int analyze(int targetLength) {
        int count = 1;
        int lastLocation = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int location = arr[i];

            if (location - lastLocation >= targetLength) {
                count += 1;

                lastLocation = location;
            }
        }

        return count;
    }

    private static int binarySearch() {
        int l = 0;
        int r = arr[arr.length - 1] - arr[0] + 1;

        while (l < r) {
            int mid = (l + r) / 2;

            if (analyze(mid) < C) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return l - 1;
    }
}