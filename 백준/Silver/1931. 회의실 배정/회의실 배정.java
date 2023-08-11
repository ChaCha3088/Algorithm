import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][];

        for (int n = 0; n < N; n++) {
            String[] split = br.readLine().split(" ");

            arr[n] = new int[] {Integer.parseInt(split[0]), Integer.parseInt(split[1])};
        }

        // 끝나는 시간 기준으로 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return -1;
                }
                else if (o1[1] == o2[1]) {
                    if (o1[0] < o2[0]) {
                        return -1;
                    }
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });

        int answer = 1;
        int currentEnd = arr[0][1];
        for (int n = 1; n < N; n++) {
            if (arr[n][0] >= currentEnd) {
                answer += 1;
                currentEnd = arr[n][1];
            }
        }

        System.out.println(answer);
    }
}