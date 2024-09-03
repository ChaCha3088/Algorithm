import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static long count;
    private static int[] numbers;
    private static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        isUsed = new boolean[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        countNumberOfCases();

        System.out.println(count);
    }

    public static void countNumberOfCases() {
        for(int left = 0, right = -1; left < N; left++) {
            while (right + 1 < N && !isUsed[numbers[right + 1]]) {
                right++;
                isUsed[numbers[right]] = true;
            }

            count += right - left + 1;

            isUsed[numbers[left]] = false;
        }
    }
}