import java.io.*;

public class Main {

    private static int[][] arr;
    private static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                if (split[j - 1].equals("1")) {
                    arr[i][j] = Integer.valueOf(split[j - 1]);
                }
            }
        }

        compress(1, 1, N);

        boolean isAllSame = true;
        char initialized = answer.charAt(1);
        for (int i = 2; i < answer.length() - 1; i++) {
            if (answer.charAt(i) != initialized) {
                isAllSame = false;
                break;
            }
        }

        if (isAllSame) {
            answer = String.valueOf(initialized);
        }

        System.out.println(answer);
    }

    private static void compress(int x, int y, int length) {
        int half = length / 2;

        answer += "(";

        //////////////////////////////////////////////////////
        // 왼쪽 위
        boolean leftUp = false;
        int initialized = arr[y][x];

        for (int i = y; i < y + half; i++) {
            boolean isX = false;
            for (int j = x; j < x + half; j++) {
                if (arr[i][j] != initialized) {
                    isX = true;
                    break;
                }
            }

            if (isX) {
                leftUp = true;
                break;
            }
        }

        if (leftUp) {
            compress(x, y, half);
        }
        else {
            answer += String.valueOf(initialized);
        }
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////
        // 오른쪽 위
        boolean rightUp = false;
        initialized = arr[y][x + half];

        for (int i = y; i < y + half; i++) {
            boolean isX = false;
            for (int j = x + half; j < x + length; j++) {
                if (arr[i][j] != initialized) {
                    isX = true;
                    break;
                }
            }

            if (isX) {
                rightUp = true;
                break;
            }
        }

        if (rightUp) {
            compress(x + half, y, half);
        }
        else {
            answer += String.valueOf(initialized);
        }
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////
        // 왼쪽 아래
        boolean leftDown = false;
        initialized = arr[y + half][x];

        for (int i = y + half; i < y + length; i++) {
            boolean isX = false;
            for (int j = x; j < x + half; j++) {
                if (arr[i][j] != initialized) {
                    isX = true;
                    break;
                }
            }

            if (isX) {
                leftDown = true;
                break;
            }
        }

        if (leftDown) {
            compress(x, y + half, half);
        }
        else {
            answer += String.valueOf(initialized);
        }
        //////////////////////////////////////////////////////

        //////////////////////////////////////////////////////
        // 오른쪽 아래
        boolean rightDown = false;
        initialized = arr[y + half][x + half];

        for (int i = y + half; i < y + length; i++) {
            boolean isX = false;
            for (int j = x + half; j < x + length; j++) {
                if (arr[i][j] != initialized) {
                    isX = true;
                    break;
                }
            }

            if (isX) {
                rightDown = true;
                break;
            }
        }

        if (rightDown) {
            compress(x + half, y + half, half);
        }
        else {
            answer += String.valueOf(initialized);
        }
        //////////////////////////////////////////////////////

        answer += ")";
    }
}