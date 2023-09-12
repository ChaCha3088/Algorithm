import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int result = 2;
    private static char[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // 초기화
            result = 2;

            // 입력
            chars = br.readLine().toCharArray();

            int l = 0;
            int r = chars.length - 1;

            explore(l, r, false);

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void explore(int l, int r, boolean isUsed) {
        if (l < r) {
            // 둘이 같으면
            if (chars[l] == chars[r]) {
                explore(l + 1, r - 1, isUsed);
            }
            // 다르면
            else {
                // 기회가 남아있다면
                if (!isUsed) {
                    // 왼쪽을 오른쪽으로
                    explore(l + 1, r, true);

                    // 오른쪽을 왼쪽으로
                    explore(l, r - 1, true);
                }
            }
        }
        else {
            // 기회 없이 성공했다면
            if (!isUsed) {
                // 회문
                if (0 < result) {
                    result = 0;
                }
            }
            // 기회를 사용했다면
            else {
                // 유사 회문
                if (1 < result) {
                    result = 1;
                }
            }
        }
    }
}