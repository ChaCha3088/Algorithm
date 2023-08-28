import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int[] arr;
    private static List[] boxes;
    private static int maxCount;
    private static int minDiff;
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            maxCount = N / 2;

            Arrays.sort(arr);

            boxes = new List[3];


            boolean isSuccess = true;
            int diff = -1;
            minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                boxes[i] = new ArrayList<>();
            }

            dfs(0, 0);

            if (minDiff == Integer.MAX_VALUE) {
                isSuccess = false;
            }

            sb.append("#").append(t).append(" ");

            if (isSuccess) {
                sb.append(minDiff).append("\n");
            }
            else {
                sb.append(-1).append("\n");
            }

        }
        System.out.println(sb);
    }

    private static boolean dfs(int pointer, int boxPointer) {
        if (boxPointer >= 3) {
            // 성공한거 아니면 꺼져
            if (pointer != N) {
                return false;
            }

            int maxValue = 0;
            int minValue = Integer.MAX_VALUE;

            // 당근의 개수들 최대 최소 계산하여 업데이트
            for (int i = 0; i < 3; i++) {
                if (boxes[i].size() > maxValue) {
                    maxValue = boxes[i].size();
                }
                if (boxes[i].size() < minValue) {
                    minValue = boxes[i].size();
                }
            }

            int diff = maxValue - minValue;

            if (diff >= 0 && minDiff > diff) {
                minDiff = diff;
            }

            return false;
        }

        boolean isPossible = true;

        // 숫자 추가
        List<Integer> buffer = new ArrayList<>();
        int tempPointer = pointer;
        int lastOne;

        while (boxes[boxPointer].size() < maxCount && tempPointer <= N - 1 && isPossible) {
            lastOne = arr[tempPointer];

            // 같은 숫자가 안나올 때까지 넣는다.
            buffer.add(lastOne);

            while (tempPointer + 1 <= N - 1 && lastOne == arr[tempPointer + 1]) {
                tempPointer += 1;
                lastOne = arr[tempPointer];
                buffer.add(lastOne);
            }

            // 박스에 들어가는게 가능하면
            if (boxes[boxPointer].size() + buffer.size() <= maxCount) {
                for (int element : buffer) {
                    boxes[boxPointer].add(element);
                }

                dfs(tempPointer + 1, boxPointer + 1);

                for (int i = 1; i <= buffer.size(); i++) {
                    boxes[boxPointer].remove(boxes[boxPointer].size() - 1);
                }
            }
            else {
                isPossible = false;
            }

            tempPointer += 1;
        }

        return isPossible;
    }
}