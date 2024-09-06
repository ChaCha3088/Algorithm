import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int[] arr;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int m = 1; m <= N; m++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int bool = Integer.parseInt(st.nextToken());

                if (bool == 1) {
                    union(m, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int first = find(Integer.parseInt(st.nextToken()));
        while (st.hasMoreTokens()) {
            if (find(Integer.parseInt(st.nextToken())) != first) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
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