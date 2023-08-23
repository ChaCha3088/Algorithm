import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List[] arr;
    private static boolean[] history;
    private static int answer = 0;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new List[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        history = new boolean[N];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            arr[first].add(second);

            arr[second].add(first);
        }

        for (int i = 0; i < N; i++) {
            // 방문 안했으면
            if (history[i] == false) {
                // 기록 남기고
                history[i] = true;

                // 방문
                dfs(i, 0);

                if (answer == 1) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int target, int depth) {
        if (answer == 1) {
            return;
        }

        if (depth == 4) {
            answer = 1;
            return;
        }

        for (int i = 0; i < arr[target].size(); i++) {
            if (answer == 1) {
                return;
            }

            // 방문 안했으면
            if (history[(int) arr[target].get(i)] == false) {
                // 기록 남기고
                history[target] = true;

                // 방문
                dfs((int) arr[target].get(i), depth + 1);

                history[target] = false;
            }
        }
    }
}