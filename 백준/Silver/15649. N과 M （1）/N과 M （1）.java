import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int[] arr;
    private static List<Integer> occupiedIndex = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();
    private static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수 입력 받기
        String[] split = br.readLine().split(" ");
        int N = Integer.valueOf(split[0]);
        int M = Integer.valueOf(split[1]);

        // 배열 초기화
        arr = new int[N + 1];

        // 1부터 N까지 배열 채우기
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        find(0, M);

        // 정답 배열 출력
        for (int i = 0; i < results.size(); i++) {
            String string = "";

            for (int j = 0; j < results.get(0).size(); j++) {
                string += results.get(i).get(j) + " ";
            }

            System.out.println(string);
        }
    }

    private static void find(int currentDepth, int targetDepth) {
        if (currentDepth == targetDepth) {
            List<Integer> saveTemp = new ArrayList<>();

            // 결과에 저장
            for (int i = 0; i < temp.size(); i++) {
                saveTemp.add(temp.get(i));
            }

            results.add(saveTemp);
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            // 인덱스 사용 중이면 continue
            if (occupiedIndex.contains(i)) {
                continue;
            }

            // 인덱스 기록
            occupiedIndex.add(i);

            // temp에 숫자 넣기
            temp.add(i);

            // 재귀 호출
            find(currentDepth + 1, targetDepth);

            // temp 맨 마지막 삭제
            temp.remove(temp.size() - 1);

            // 인덱스 기록 삭제
            occupiedIndex.remove(occupiedIndex.size() - 1);
        }
    }
}