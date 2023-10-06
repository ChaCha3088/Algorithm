import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int max;
    private static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            max = 0;
            int left = 0;

            // 입력
            int N = Integer.parseInt(br.readLine());
            heights = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                heights[n] = Integer.parseInt(st.nextToken());
                left += heights[n];

                // 최대값 찾기
                if (heights[n] > max) {
                    max = heights[n];
                }
            }

            int total = N * max;
            left = total - left;
            int day = 0;

            List<Integer> leftOvers = new ArrayList();

            // 남은 수
            for (int n = 0; n < N; n++) {
                int leftToGrow = max - heights[n];

                if (leftToGrow >= 1) {
                    leftOvers.add(leftToGrow);
                }
            }

            // 정렬
            Collections.sort(leftOvers);

            while (!leftOvers.isEmpty()) {
                day += 1;

                // 짝수 날일 때
                if (day % 2 == 0) {
                    // 하나 남았을 때
                    if (leftOvers.size() == 1) {
                        // 2 이상 남았으면
                        if (leftOvers.get(0) >= 2) {
                            leftOvers.set(0, leftOvers.get(0) - 2);

                            // 다 자랐으면
                            if (leftOvers.get(0) == 0) {
                                leftOvers.remove(0);
                            }
                        }
                        // 1 남았으면, 다음 날에 물 준다.

                    }
                    // 두개 이상 남았을 때
                    else if (leftOvers.size() >= 2) {
                        for (int i = 0; i < leftOvers.size(); i++) {
                            if (leftOvers.get(i) >= 2) {
                                leftOvers.set(i, leftOvers.get(i) - 2);

                                if (leftOvers.get(i) == 0) {
                                    leftOvers.remove(i);
                                }

                                break;
                            }
                        }
                    }
                }
                // 홀수 날일 때
                else {
                    // 하나 남았을 때
                    if (leftOvers.size() == 1) {
                        // 2 남은거 아니면 물 주기
                        if (leftOvers.get(0) != 2) {
                            leftOvers.set(0, leftOvers.get(0) - 1);

                            if (leftOvers.get(0) == 0) {
                                leftOvers.remove(0);
                            }
                        }
                    }
                    // 두개 이상 남았을 때
                    else if (leftOvers.size() >= 2) {
                        leftOvers.set(0, leftOvers.get(0) - 1);

                        if (leftOvers.get(0) == 0) {
                            leftOvers.remove(0);
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(day).append("\n");
        }

        System.out.println(sb);
    }
}