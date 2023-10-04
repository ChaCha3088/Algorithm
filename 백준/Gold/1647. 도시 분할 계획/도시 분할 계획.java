import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static List<int[]> paths = new ArrayList();
    private static int[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new int[N + 1];

        // nodes 초기화
        for (int i = 0; i <= N; i++) {
            nodes[i] = i;
        }

        // 입력
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            paths.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 정렬
        Collections.sort(paths, Comparator.comparingInt(o -> ((int[]) o)[2]));

        int answer = 0;
        int bigCost = 0;

        for (int i = 0; i < paths.size(); i++) {
            int[] path = paths.get(i);

            // 사이클이 발생하지 않는다면
            if (find(path[0]) != find(path[1])) {
                // 유지비 합
                answer += path[2];

                // 길을 만든다.
                union(path[0], path[1]);

                // 가장 큰 유지비
                bigCost = path[2];
            }
        }

        System.out.println(answer - bigCost);
    }

    private static void union(int x, int y) {
        // 각 원소가 속한 트리의 부모 노드를 찾는다.
        x = find(x);
        y = find(y);

        if (x != y) {
            nodes[y] = x;
        }
    }

    private static int find(int target) {
        // 루트 노드는 부모 노드 번호로 자기 자신을 가진다.
        if (nodes[target] == target) {
            return target;
        }
        // 각 노드의 부모 노드가 나올 때까지 찾아 올라간다.
        else {
            return nodes[target] = find(nodes[target]);
        }
    }
}