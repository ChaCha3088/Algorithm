import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, answer;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (!union(u, v)) {
                answer += 1;
            }
        }

        Set<Integer> hs = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            hs.add(find(i));
        }
        answer += (hs.size() - 1);

        System.out.println(answer);
    }

    private static boolean union(int x, int y) {
        if (x > y) {
            int temp = y;
            y = x;
            x = temp;
        }

        int a = find(x);
        int b = find(y);

        if (a == b) {
            return false;
        }
        else {
            parents[b] = a;
            return true;
        }
    }

    private static int find(int target) {
        return parents[target] < 0 ? target : (parents[target] = find(parents[target]));
    }
}