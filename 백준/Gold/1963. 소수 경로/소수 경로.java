import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        prime = new boolean[10000];
        prime[0] = prime[1] = true;
        for (int i = 2; i < 10000; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < 10000; j += i) {
                    prime[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];// 방문여부 확인
            int[] count = new int[10000]; // 최소 횟수 저장배열

            queue.offer(a);
            visited[a] = true;

            while (!queue.isEmpty()) {
                int num = queue.poll();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j <= 9; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int k = change(num, i, j);
                        if (!prime[k] && !visited[k]) {
                            queue.offer(k);
                            visited[k] = true;
                            count[k] = count[num] + 1;
                        }
                    }
                }
            }
            System.out.println(count[b]);
        }
    }

    public static int change(int num, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(i, (char) (j + '0'));
        
        return Integer.parseInt(sb.toString());
    }
}