import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int[] arr;
    private static int[] target;
    private static int[] nonTarget;

    private static int winning = 0;
    private static int loosing = 0;
    private static int gu;
    private static int in;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            gu = 0;
            in = 0;
            winning = 0;
            loosing = 0;

            String[] split = br.readLine().split(" ");

            arr = new int[19];
            nonTarget = new int[9];

            // 입력 받기
            for (int n = 1; n <= 9; n++) {
                arr[Integer.parseInt(split[n - 1])] += 1;
                nonTarget[n - 1] = Integer.parseInt(split[n - 1]);
            }

            // 인영이 덱 만들기
            target = new int[9];
            int index = 0;
            for (int n = 1; n <= 18; n++) {
                if (arr[n] == 0) {
                    target[index] = n;
                    index += 1;
                }
            }

            // 순열 만들기
            // 대상 정렬
            Arrays.sort(target);

            do {
                // 승패 확인
                evaluate();
            } while (nextPermutation());

            sb.append("#").append(test).append(" ").append(winning).append(" ").append(loosing).append("\n");
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
        for (int round = 0; round < 9; round++) {
            if (nonTarget[round] > target[round]) {
                gu += nonTarget[round] + target[round];
            }
            else if (nonTarget[round] < target[round]) {
                in += nonTarget[round] + target[round];
            }
            else {}
        }

        // 점수
        if (gu > in) {
            winning += 1;
        }
        else if (in > gu) {
            loosing += 1;
        }
        else {}

        gu = 0;
        in = 0;
    }
}