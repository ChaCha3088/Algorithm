import java.io.*;

class Solution {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            // 덤프 횟수
            int N = Integer.valueOf(br.readLine());

            // 박스 높이 입력 받기
            String[] split = br.readLine().split(" ");

            // 박스 높이 배열 초기화
            arr = new int[101];

            // 박스 높이 기록
            for (int j = 0; j < split.length; j++) {
                int boxHeight = Integer.valueOf(split[j]);
                arr[j + 1] += boxHeight;
            }

            // 최소, 최대 포인터 초기화
            int[] minMaxIndex = findMinMaxIndex();
            int minPointer = minMaxIndex[0];
            int maxPointer = minMaxIndex[1];
            int difference = minMaxIndex[2];

            // 덤프 횟수만큼 반복
            for (int j = 0; j < N; j++) {
                // 평탄화가 완료되면 끝
                if (difference <= 1) {
                    break;
                }

                // 가장 높은 곳에 있는 것을
                arr[maxPointer] -= 1;

                // 가장 낮은 곳으로 옮김
                arr[minPointer] += 1;

                // 최소, 최대 포인터 갱신
                minMaxIndex = findMinMaxIndex();
                minPointer = minMaxIndex[0];
                maxPointer = minMaxIndex[1];
                difference = minMaxIndex[2];
            }

            // 출력
            sb.append("#").append(i).append(" ").append(Math.abs(difference));
            System.out.println(sb);

            // StringBuilder 초기화
            sb = new StringBuilder();
        }
    }

    private static int[] findMinMaxIndex() {
        int minValue = Integer.MAX_VALUE;
        int maxValue = 0;
        int maxIndex = -1;
        int minIndex = -1;

        for (int i = 1; i <= 100; i++) {
            // 최소값 찾기
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }

            // 최대값 찾기
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }

        int difference = Math.abs(maxValue - minValue);

        return new int[] {minIndex, maxIndex, difference};
    }
}