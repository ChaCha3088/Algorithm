import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int N;
    private static int M;
    private static List<Integer> temp = new ArrayList<>();
    private static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        make(0, M, 1);

        // sb에 결과 작성
        for (List<Integer> list : results) {
            for (int value : list) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void make(int currentDepth, int targetDepth, int start) {
        // 목표 길이에 도달하면 끝
        if (currentDepth >= targetDepth) {
            // 결과 저장
            results.add(List.copyOf(temp));
            return;
        }

        for (int i = start; i <= N; i++) {
            // temp에 값 추가
            temp.add(i);

            make(currentDepth + 1, targetDepth, i + 1);

            // temp 마지막 삭제
            temp.remove(temp.size() - 1);
        }
    }
}