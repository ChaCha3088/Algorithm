import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int answer;
    private static int N;
    private static int[][] arr;
    private static int[] target;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            answer = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];

            for (int n = 0; n < N; n++) {
                String[] split = br.readLine().split(" ");

                for (int s = 0; s < split.length; s++) {
                    arr[n][s] = Integer.parseInt(split[s]);
                }
            }

            // 배열 초기화
            target = new int[N];

            // 배열 채우기
            for (int n = N / 2; n < N; n++) {
                target[n] = 1;
            }

            do {
                // 시너지 확인
                evaluate();
            } while (nextPermutation());

            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean nextPermutation() {
        int i = target.length - 1;

        // 꼭대기 찾기
        while (i > 0 && target[i - 1] >= target[i]) {
            i -= 1;
        }

        // 꼭대기 못 찾고 끝까지 가면 끝
        if (i <= 0) {
            return false;
        }

        // 꼭대기 찾았으면
        int j = target.length - 1;

        // swap 대상 찾기
        while (target[j] <= target[i - 1]) {
            j -= 1;
        }

        // swap 하기
        swap(i - 1, j);

        // j 설정
        j = target.length - 1;

        // 꼭대기부터 끝까지 정렬하기
        while (i < j) {
            swap(i, j);
            i += 1;
            j -= 1;
        }

        // 모든 걸 완수하면
        return true;
    }

    private static void swap(int i, int j) {
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }

    private static void evaluate() {
        int A = 0;
        int B = 0;

        int[] AIndex = new int[N / 2];
        int[] BIndex = new int[N / 2];

        int ai = 0;
        int bi = 0;

        for (int i = 0; i < target.length; i++) {
            if (target[i] == 0) {
                AIndex[ai] = i;
                ai += 1;
            }
            else if (target[i] == 1) {
                BIndex[bi] = i;
                bi += 1;
            }
        }

        for (int i = 0; i < AIndex.length; i++) {
            for (int j = 0; j < AIndex.length; j++) {
                if (i != j) {
                    A += arr[AIndex[i]][AIndex[j]];

                    B += arr[BIndex[i]][BIndex[j]];
                }
            }
        }

        int result = Math.abs(A - B);

        if (result < answer) {
            answer = result;
        }
    }
}