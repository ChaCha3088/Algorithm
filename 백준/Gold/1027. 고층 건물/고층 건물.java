import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    private static int[] arr;
    private static int max = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        arr = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int result = inspect(i);

            if (result > max) {
                max = result;
            }
        }

        System.out.println(max);
    }

    private static int inspect(int i) {
        // 왼쪽
        int leftCount = 0;
        double leftSlope = Double.MAX_VALUE;
        int leftI = i - 1;
        while (true) {
            if (leftI < 0) {
                break;
            }

            double slope = (double) (arr[i] - arr[leftI]) / (i - leftI);

            // 다른 빌딩을 지나거나 접하면
            if (slope >= leftSlope) {
                leftI -= 1;
                continue;
            }

            leftCount += 1;

            leftSlope = slope;

            leftI -= 1;
        }

        // 오른쪽
        int rightCount = 0;
        double rightSlope = -1 * Double.MAX_VALUE;
        int rightI = i + 1;
        while (true) {
            if (rightI >= N) {
                break;
            }

            double slope = (double) (arr[rightI] - arr[i]) / (rightI - i);

            // 다른 빌딩을 지나거나 접하면
            if (slope <= rightSlope) {
                rightI += 1;
                continue;
            }

            rightCount += 1;

            rightSlope = slope;

            rightI += 1;
        }

        return leftCount + rightCount;
    }
}