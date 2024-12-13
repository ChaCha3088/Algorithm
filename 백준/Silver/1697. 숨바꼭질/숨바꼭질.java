import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static int[] arr;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[100_001];
        for (int i = 0; i < 100_001; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        queue.offer(K);
        arr[K] = 0;

        while (!queue.isEmpty()) {
            int target = queue.poll();

            if (target > 100_000) {
                continue;
            }

            if (target + 1 <= 100_000) {
                if (arr[target] + 1 < arr[target + 1]) {
                    queue.offer(target + 1);
                    arr[target + 1] = arr[target] + 1;
                }
            }

            if (target - 1 >= 0) {
                if (arr[target] + 1 < arr[target - 1]) {
                    queue.offer(target - 1);
                    arr[target - 1] = arr[target] + 1;
                }
            }

            // 짝수
            if (target % 2 == 0) {
                if (arr[target] + 1 < arr[target / 2]) {
                    queue.offer(target / 2);
                    arr[target / 2] = arr[target] + 1;
                }
            }
        }

        System.out.println(arr[N]);
    }
}