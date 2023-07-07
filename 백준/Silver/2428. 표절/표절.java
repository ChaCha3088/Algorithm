import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(arr);

        long sum = 0;

        //처음부터 마지막꺼 전까지 돌건데
        for (int i = 0; i < N; i++) {
            sum += find(i);
        }

        sb.append(sum);

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    //검사 시작해야하는 수의 idx 반환
    private static int find(int i) {
        int l = i;
        int r = N - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[i] >= arr[mid] * 0.9) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return l - i - 1;
    }
}