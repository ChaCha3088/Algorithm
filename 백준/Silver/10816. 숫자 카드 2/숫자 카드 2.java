import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static StringBuffer sb = new StringBuffer();

    // 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int input = Integer.parseInt(st.nextToken());
            arr[n] = input;
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            int target = Integer.parseInt(st.nextToken());
            int leftIndex = leftFind(target);
            int rightIndex = rightFind(target);


            sb.append(rightIndex - leftIndex).append(" ");
        }

        System.out.println(sb);
    }

    private static int leftFind(int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return l;
    }

    private static int rightFind(int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] > target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return l;
    }
}