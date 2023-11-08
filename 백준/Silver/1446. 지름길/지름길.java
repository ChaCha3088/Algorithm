import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, D;
    private static int[] roadDp;
    private static List<List<Integer>> maps = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        roadDp = new int[10_001];

        for (int i = 1; i <= D; i++) {
            roadDp[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }

            maps.add(temp);
        }

        // start, end, length sort
        Collections.sort(maps, (o1, o2) -> {
            if (o1.get(1).equals(o2.get(1))) {
                if (o1.get(0).equals(o2.get(0))) {
                    return o1.get(2) - o2.get(2);
                }

                return o1.get(0) - o2.get(0);
            }

            return o1.get(1) - o2.get(1);
        });

        for (List<Integer> shortCut : maps) {
            int start = shortCut.get(0);
            int end = shortCut.get(1);
            int length = shortCut.get(2);

            if (roadDp[end] - roadDp[start] > length) {
                // 거리 업데이트
                roadDp[end] = roadDp[start] + length;

                // end부터 고속도로 끝까지 업데이트
                int j = end + 1;
                // 얼마나 줄였어?
                while (j <= D) {
                    roadDp[j] = roadDp[j - 1] + 1;

                    j += 1;
                }
            }
        }

        System.out.println(roadDp[D]);
    }
}