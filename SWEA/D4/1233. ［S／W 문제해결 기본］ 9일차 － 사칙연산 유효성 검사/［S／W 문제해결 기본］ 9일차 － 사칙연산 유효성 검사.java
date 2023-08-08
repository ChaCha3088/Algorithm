import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test = 1; test <= 10; test++) {
            int N = Integer.parseInt(br.readLine());

            int answer = 0;

            int where = 0;

            for (int n = 1; n <= N; n++) {
                String[] split = br.readLine().split(" ");

                // 리프 노드
                if (split.length == 2) {
                    try {
                        Integer.parseInt(split[1]);
                    } catch (NumberFormatException e) {
                        where = n;
                        break;
                    }
                }
                // 리프 노드가 아닐 때
                else {
                    try {
                        Integer number = Integer.parseInt(split[1]);
                        if (number instanceof Integer) {
                            where = n;
                            break;
                        }
                    } catch (NumberFormatException e) {
                    }
                }

                if (n == N) {
                    answer = 1;
                }
            }

            if (answer == 0 && where < N) {
                for (int j = where + 1; j <= N; j++) {
                    br.readLine();
                }
            }

            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}