import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int N, S, answer = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    private static void dfs(int index, int currentSum) {
        int sum = currentSum + arr[index];

        if (sum == S) {
            answer += 1;
        }

        for (int i = index + 1; i < N; i++) {
            dfs(i, sum);
        }
    }
}