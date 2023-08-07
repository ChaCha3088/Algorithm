import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testCase 10개 반복
        for (int test = 1; test <= 10; test++) {
            // 원본 암호문의 길이 N 입력
            int N = Integer.parseInt(br.readLine());

            // LinkedList 생성
            List<Integer> ll = new LinkedList<>();

            // 원본 암호문 입력
            String[] split = br.readLine().split(" ");

            // LinkedList에 추가
            for (int i = 0; i < split.length; i++) {
                ll.add(Integer.parseInt(split[i]));
            }

            // 명령어의 개수 입력
            int I = Integer.parseInt(br.readLine());

            // 명령어 입력
            String[] split1 = br.readLine().split("I ");

            // 추가
            for (int i = 1; i <= I; i++) {
                String[] split2 = split1[i].split(" ");
                int x = Integer.parseInt(split2[0]);
                int y = Integer.parseInt(split2[1]);

                int index = 0;
                for (int j = x; j < x + y; j++) {
                    ll.add(j, Integer.parseInt(split2[2 + index]));
                    index += 1;
                }
            }

            // StringBuilder
            sb.append("#").append(test).append(" ");

            int target = 0;
            if (ll.size() < 10) {
                target = ll.size();
            }
            else {
                target = 10;
            }

            for (int i = 0; i < target; i++) {
                sb.append(ll.get(i)).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}