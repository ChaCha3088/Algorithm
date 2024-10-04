import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] parents;
    private static List[] infos;
    private static StringBuffer sb =  new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        infos = new List[N + 1];

        for (int n = 1; n <= N; n++) {
            infos[n] = new ArrayList<>();
        }

        for (int n = 0; n < N - 1; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            infos[first].add(second);
            infos[second].add(first);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        parents[1] = 1;

        while (!queue.isEmpty()) {
            int polled = queue.poll();

            for (int i = 0; i < infos[polled].size(); i++) {
                int element = (int) infos[polled].get(i);

                if (parents[element] == 0) {
                    parents[element] = polled;

                    queue.offer(element);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }
}