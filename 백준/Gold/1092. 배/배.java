import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, maxCrane;
    private static List<Integer> limits = new ArrayList<>();
    private static List<Integer> boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        maxCrane = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int crane = Integer.parseInt(st.nextToken());
            limits.add(crane);

            if (crane > maxCrane) {
                maxCrane = crane;
            }
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            int box = Integer.parseInt(st.nextToken());

            if (box > maxCrane) {
                System.out.println(-1);
                return;
            }

            boxes.add(box);
        }

        // 정렬
        limits.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        int day = 0;
        while (!boxes.isEmpty()){
            int boxIdx = 0, craneIdx = 0;

            while (craneIdx < N) {
                if (boxIdx == boxes.size()) {
                    break;
                }
                else if (limits.get(craneIdx) >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    craneIdx++;
                }
                else {
                    boxIdx++;
                }
            }

            day++;
        }

        System.out.println(day);
    }
}