import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int[] arr;
    private static int N, M;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int inst = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (inst == 0) {
                union(a, b);
            }
            else {
                if (isSame(a, b)) {
                    sb.append("YES").append("\n");
                }
                else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int resultA = find(a);
        int resultB = find(b);

        if (resultA != resultB) {
            arr[resultB] = resultA;
        }
    }

    private static boolean isSame(int a, int b) {
        int resultA = find(a);
        int resultB = find(b);

        return resultA == resultB;
    }

    private static int find(int input) {
        if (arr[input] == input) {
            return arr[input];
        }

        return arr[input] = find(arr[input]);
    }
}