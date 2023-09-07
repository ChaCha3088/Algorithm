import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Map<Integer, List<Integer>> arr;
    private static int count = 0;
    private static boolean[] visited;
    private static boolean[] earlyAdapter;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        // 초기화
        arr = new HashMap();
        visited = new boolean[N + 1];
        earlyAdapter = new boolean[N + 1];

        // 입력
        for (int n = 1; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            offer(u, v);
            offer(v, u);
        }

        dfs(1, 1);

        System.out.println(count);
    }

    private static void dfs(int target, int depth) {
        visited[target] = true;
        List next = arr.getOrDefault(target, new ArrayList());


        List<Integer> children = new ArrayList();

        for (int i = 0; i < next.size(); i++) {
            int nextOne = (int) next.get(i);

            if (!visited[nextOne]) {
                children.add(nextOne);

                // 탐색
                dfs(nextOne, depth + 1);
            }
        }

        boolean needToCheck = false;
        for (int i = 0; i < children.size(); i++) {
            // 한명이라도 얼리어답터가 아닌 애가 있으면
            if (!earlyAdapter[(int) children.get(i)]) {
                needToCheck = true;
                break;
            }
        }

        // 본인을 얼리아답터로 만든다.
        if (needToCheck) {
            earlyAdapter[target] = true;
            count += 1;
        }
    }

    private static boolean isThereChild(List next, int target) {
        for (int i = 0; i < next.size(); i++) {
            int nextOne = (int) next.get(i);

            if (!visited[nextOne]) {
                return true;
            }
        }

        return false;
    }

    private static void offer(int u, int v) {
        List uResult = arr.getOrDefault(u, new ArrayList());
        if ((uResult.size() == 0)) {
            uResult.add(v);
            arr.put(u, uResult);
        }
        else {
            uResult.add(v);
        }
    }
}