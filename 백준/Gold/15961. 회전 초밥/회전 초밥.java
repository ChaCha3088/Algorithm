import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int answer = 0;
    private static int[] arr;
    private static int[] visited;
    private static int N, D, K, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new int[D + 1];

        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        slide();

        System.out.println(answer);
    }

    private static void slide() {
        int total = 0;

        for (int i = 0; i < K; i++) {
            if (visited[arr[i]] == 0) {
                total++;
            }
            visited[arr[i]]++;
        }
        answer = total;

        if (visited[C] == 0) {
            answer += 1;
        }
        
        int result = 0;

        for (int i = 1; i < N; i++) {
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) {
                total--;
            }

            if (visited[arr[(i + K - 1) % N]] == 0) {
                total++;
            }
            visited[arr[(i + K - 1) % N]]++;

            if (visited[C] == 0) {
                result = total + 1;
            }
            else {
                result = total;
            }

            if (result > answer) {
                answer = result;
            }
        }
    }
}