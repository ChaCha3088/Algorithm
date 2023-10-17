import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] numbers;
    private static int[] buhos;
    private static long answer;
    private static List<Integer> subsets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int half = N / 2;
        numbers = new int[half + 1];
        buhos = new int[half];

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            int index = i / 2;
            if (i % 2 == 0) {
                numbers[index] = input.charAt(i) - '0';
            }
            else {
                buhos[index] = input.charAt(i) - '*';
            }
        }

        answer = Long.MIN_VALUE;

        // 아무것도 안한거 계산
        process();

        for (int i = 0; i < buhos.length; i++) {
            subset(i);
        }

        System.out.println(answer);
    }

    private static void subset(int index) {
        subsets.add(index);

        process();

        for (int i = index + 2; i < buhos.length; i++) {
            subset(i);
        }

        subsets.remove(subsets.size() - 1);
    }

    private static void process() {
        Queue<Long> queue = new ArrayDeque<>();

        // 여기에 있는거 미리 계산해서 큐에 넣을거야
        int index = 0;
        for (int i = 0; i < buhos.length; i++) {
            // 이 때만 계산해
            if (index < subsets.size()) {
                // 숫자가 같을 때
                if (i == subsets.get(index)) {
                    // 계산해서 넣어야 해
                    long calculated = calculate(numbers[i], buhos[i], numbers[i + 1]);
                    queue.offer(calculated);
                    if (i + 1 < buhos.length) {
                        queue.offer((long) buhos[i + 1]);
                    }

                    i += 1;
                    index += 1;
                    continue;
                }
            }

            // 편하게 큐에 넣어
            queue.offer((long) numbers[i]);
            queue.offer((long) buhos[i]);
        }

        if (queue.size() % 2 == 0) {
            queue.offer((long) numbers[numbers.length - 1]);
        }


        // 계산하는
        // 첫번째 값 꺼내서 result에 박고 시작
        long result = queue.poll();
        while (!queue.isEmpty()) {
            long buho = queue.poll();
            long number = queue.poll();

            result = calculate(result, buho, number);
        }

        if (result > answer) {
            answer = result;
        }
    }

    private static long calculate(long result, long buho, long number) {
        // *
        if (buho == 0) {
            return result * number;
        }
        // +
        else if (buho == 1) {
            return result + number;
        }
        // -
        else {
            return result - number;
        }
    }
}