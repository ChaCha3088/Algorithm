import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int N;
    private static int[] parents;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 집합 만들기
            makeSet();

            for (int m = 1; m <= M; m++) {
                st = new StringTokenizer(br.readLine());

                // 합집합
                if (st.nextToken().equals("0")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    unionSet(a, b);
                }
                else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    sb.append(checkSet(a, b));
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void makeSet() {
        parents = new int[N + 1];

        // 모든 요소를 자신만 갖는 단위 서로소 집합이 되도록 만든다.
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int target) {
        if (target == parents[target]) {
            return target;
        }

        // 개선 후
        return parents[target] = findSet(parents[target]);
    }

    // 합칠 수 있으면 true, 아니면 false
    private static void unionSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return;
        }

        parents[bRoot] = aRoot;
    }

    private static int checkSet(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return 1;
        }

        return 0;
    }
}