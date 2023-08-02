import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Combination {
    int x;
    int y;
    double cost;

    Combination(int x, int y, double cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class Solution {
    private static int N;
    private static double E;
    private static int[] parent;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            // 섬의 개수
            N = Integer.parseInt(br.readLine());

            map = new int[N + 1][];

            String[] x = br.readLine().split(" ");
            String[] y = br.readLine().split(" ");

            for (int j = 1; j <= N; j++) {
                map[j] = new int[] {Integer.parseInt(x[j - 1]), Integer.parseInt(y[j - 1])};
            }

            E = Double.parseDouble(br.readLine());

            List<Combination> list = combination();

            parent = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                parent[j] = j;
            }

            double answer = 0;

            for (int j = 1; j <= list.size(); j++) {
                int xP = list.get(j - 1).x;
                int yP = list.get(j - 1).y;
                if (!hasSameParent(xP, yP)) {
                    union(xP, yP);
                    answer += list.get(j - 1).cost;
                }
            }

            // 출력
            System.out.format("#%d %.0f\n", i, answer);
        }
    }

    private static List<Combination> combination() {
        List<Combination> list = new ArrayList<>();

        // 1부터 N까지
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int[] a = map[i];
                int[] b = map[j];

                double cost = E * (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));

                list.add(new Combination(i, j, cost));
            }
        }

        // 정렬
        list.sort(new Comparator<Combination>() {
            @Override
            public int compare(Combination o1, Combination o2) {
                if (o1.cost < o2.cost) {
                    return -1;
                }
                else if (o1.cost > o2.cost) {
                    return 1;
                }
                return 0;
            }
        });

        return list;
    }

    private static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    private static boolean hasSameParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) {
            return false;
        }

        return true;
    }

    private static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        else {
            return parent[x] = findParent(parent[x]);
        }
    }
}