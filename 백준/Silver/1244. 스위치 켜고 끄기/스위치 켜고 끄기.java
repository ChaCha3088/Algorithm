import java.io.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 스위치 개수
        int N = Integer.valueOf(br.readLine());

        // 배열 초기화
        arr = new int[N + 1];

        // 스위치 상태 입력
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i + 1] = Integer.valueOf(split[i]);
        }

        // 학생 수
        int students = Integer.valueOf(br.readLine());

        for (int i = 0; i < students; i++) {
            String[] split1 = br.readLine().split(" ");

            int sex = Integer.valueOf(split1[0]);
            int number = Integer.valueOf(split1[1]);

            // 남학생은
            if (sex == 1) {
                for (int j = number; j <= N; j += number) {
                    // 켜져 있으면
                    if (arr[j] == 1) {
                        // 끈다.
                        arr[j] = 0;
                    }
                    // 꺼져 있으면
                    else {
                        // 켠다.
                        arr[j] = 1;
                    }
                }
            }
            // 여학생은
            else {
                int howFar = 1;

                while (true) {
                    // 스위치 범위 내에 있을 때만
                    if (number - howFar >= 1 && number + howFar <= N) {
                        // 범위 넓혀간 두 스위치 상태가 같으면
                        if (arr[number - howFar] == arr[number + howFar]) {
                            // 범위를 넓힌다.
                            howFar += 1;
                        }
                        // 다르면 반복문을 종료한다.
                        else {
                            howFar -= 1;
                            break;
                        }
                    }
                    // 스위치 범위 밖이면
                    else {
                        howFar -= 1;
                        break;
                    }
                }

                // 얼마나 확장할 수 있는지 결정되면
                // number - howFar부터 number + howFar까지 상태를 바꾼다.
                for (int j = number - howFar; j <= number + howFar; j++) {
                    // 켜져 있었으면
                    if (arr[j] == 1) {
                        // 끄고
                        arr[j] = 0;
                    }
                    // 꺼져 있었으면
                    else {
                        // 켠다.
                        arr[j] = 1;
                    }
                }
            }
        }

        // 마지막 상태를
        // 출력
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

        // StringBuilder 초기화
//        sb = new StringBuilder();
    }
}