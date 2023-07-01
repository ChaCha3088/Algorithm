import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int T;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            arr = new int[11][11];

            //입력
            for (int j = 1; j <= 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 9; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + (i + 1) + " ");

            //가로, 세로 확인

            boolean done = false;

            //가로
            for (int j = 1; j <= 9; j++) {
                int[] horizontal = new int[11];
                for (int k = 1; k <= 9; k++) {

                    if (horizontal[arr[j][k]] == 1) {
                        sb.append(0 + "\n");
                        done = true;
                        break;
                    }
                    horizontal[arr[j][k]] += 1;
                }
                if (done) {
                    break;
                }
            }

            if (done) {
                continue;
            }

            //세로
            for (int j = 1; j <= 9; j++) {
                int[] vertical = new int[11];
                for (int k = 1; k <= 9; k++) {
                    if (vertical[arr[k][j]] == 1) {
                        sb.append(0 + "\n");
                        done = true;
                        break;
                    }
                    vertical[arr[k][j]] += 1;
                }
                if (done) {
                    break;
                }
            }

            if (done) {
                continue;
            }

            //작은 사각형
            int xIdx = 1;
            while (xIdx <= 9) {
                int yIdx = 1;
                while (yIdx <= 9) {
                    int[] smallRec = new int[11];
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            if (smallRec[arr[xIdx + j][yIdx + k]] == 1) {
                                sb.append(0 + "\n");
                                done = true;
                                break;
                            }
                            smallRec[arr[xIdx + j][yIdx + k]] += 1;
                        }
                        if (done) {
                            break;
                        }
                    }
                    if (done) {
                        break;
                    }
                    yIdx += 3;
                }
                if (done) {
                    break;
                }
                xIdx += 3;
            }

            if (done) {
                continue;
            }

            //성공시
            sb.append(1 + "\n");
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}