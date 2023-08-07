import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static int[] results;

    static class IndexAndValue {
        int index;
        int value;

        public IndexAndValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new int[N + 1];
        results = new int[N + 1];

        // 배열 입력
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(split[i - 1]);
        }

        // stack 선언
        Stack<IndexAndValue> stack = new Stack<>();

        // 첫번째 값을 넣어준다.
        stack.push(new IndexAndValue(1, arr[1]));

        // result[1]은 무조건 0
        results[1] = 0;

        // index 2부터 시작
        for (int i = 2; i <= N; i++) {
            // top보다 큰 값이 들어오면
            if (stack.peek().value < arr[i]) {
                // arr[i] 작은 값들 다 빼줌
                while (stack.size() > 0 && stack.peek().value < arr[i]) {
                    stack.pop();
                }
            }

            // top보다 작은 값이 들어오면
            // 결과 기록
            if (stack.size() > 0) {
                IndexAndValue peek = stack.peek();
                results[i] = peek.index;
            }

            // 값을 넣어줌
            stack.push(new IndexAndValue(i, arr[i]));
        }

        for (int i = 1; i <= N; i++) {
            sb.append(results[i]).append(" ");
        }

        System.out.println(sb);
    }
}