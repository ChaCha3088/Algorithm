import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class LeafNode {
    int depth;

    public LeafNode(int depth) {
        this.depth = depth;
    }
}

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static List<List<Integer>> arr;
    private static int[] history;
    private static List<LeafNode> results = new ArrayList<>();
    private static int sumOfDepth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        history = new int[N + 1];

        // 입력
        for (int n = 1; n <= N - 1; n++) {
            String[] split = br.readLine().split(" ");

            int a = Integer.parseInt(split[0]), b = Integer.parseInt(split[1]);

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        // 1부터 dfs 시작
        dfs(1, 0);

        for (int i = 0; i < results.size(); i++) {
            sumOfDepth += results.get(i).depth;
        }

        if (sumOfDepth % 2 == 0) {
            System.out.println("No");
        }
        else {
            System.out.println("Yes");
        }
    }

    private static void dfs(int number, int depth) {
        // 방문 기록 남기고
        history[number] = 1;

        // 방문 몇 번하는지 확인
        int howMany = 0;

        // 탐색
        List<Integer> targetList = arr.get(number);
        for (int i = 0; i < targetList.size(); i++) {
            int target = targetList.get(i);

            // 방문 했으면 끝
            if (history[target] != 0) {
                continue;
            }

            // 방문 안했으면
            // 방문 몇 번 했는지 기록
            howMany += 1;

            // 방문 하자
            dfs(target, depth + 1);
        }

        // 방문 하나도 안했으면
        // 리프 노드라는 뜻이므로
        if (howMany == 0) {
            results.add(new LeafNode(depth));
        }
    }
}