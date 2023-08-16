import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static int N;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        answer = 0;

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int row) {
        // 깊이가 N과 같으면 끝.
        if (row == N) {
            answer += 1;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[row] = i;

            if (validate(row)) {
                dfs(row + 1);
            }
        }
    }

    private static boolean validate(int row) {
        for (int i = 0; i < row; i++) {
            if (arr[row] == arr[i] || row - i == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}