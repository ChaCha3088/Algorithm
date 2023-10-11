import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int T, N, max;
    private static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            max = 0;

            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                int input = Integer.parseInt(st.nextToken());

                arr.add(input);

                if (max < input) {
                    max = input;
                }
            }

            for (int i = arr.size() - 1; i >= 0; i--) {
                if (arr.get(i) >= max) {
                    arr.remove(i);
                }
            }

            Collections.sort(arr, Collections.reverseOrder());

            int days = 0;
            while (arr.size() > 0) {
                days += 1;

                // 홀수일 때
                if (days % 2 == 1) {
                    // 1개만 남았을 땐
                    if (arr.size() == 1) {
                        // 차가 2 아니면
                        if (max - arr.get(0) != 2) {
                            // 더해주고
                            arr.set(0, arr.get(0) + 1);
                        }
                    }
                    else {
                        // 더해주고
                        arr.set(0, arr.get(0) + 1);
                    }
                }
                // 짝수일 때
                else {
                    if (arr.size() == 1) {
                        int diff = max - arr.get(0);

                        if (diff >= 2) {
                            arr.set(0, arr.get(0) + 2);
                        }
                    }
                    else {
                        for (int i = 0; i < arr.size(); i++) {
                            int diff = max - arr.get(i);

                            if (diff >= 2) {
                                arr.set(i, arr.get(i) + 2);
                                if (arr.get(i) >= max) {
                                    arr.remove(i);
                                }
                                break;
                            }
                        }
                    }
                }

                removeFinished();
            }

            sb.append("#").append(t).append(" ").append(days).append("\n");
        }

        System.out.println(sb);
    }

    private static void removeFinished() {
        if (arr.get(0) >= max) {
            arr.remove(0);
        }
    }
}