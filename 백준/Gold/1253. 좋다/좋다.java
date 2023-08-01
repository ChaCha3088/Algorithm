import java.io.*;
import java.util.Arrays;

public class Main {
    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        String[] split = br.readLine().split(" ");

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;    // 음수값이 있음에 유의!
            while (true) {
                // 현재 나(i)의 위치에 있는 경우
                if (left == i) {
                    left += 1;
                }
                else if (right == i) {
                    right -= 1;
                }
                // 결과를 찾을 수 없다.
                if (left >= right) {
                    break;
                }

                // 정렬이 되어 있으므로, 합이 더 크다면 더 작은 수와 더해주어야 하니까 왼쪽으로 움직이는 right 값을 변경
                if (arr[left] + arr[right] > arr[i]) {
                    right -= 1;
                }
                else if (arr[left] + arr[right] < arr[i]) {
                    left += 1;
                }
                else{
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}