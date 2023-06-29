import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    private static int T;
    private static int[] scores;

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            scores = new int[101];
            
            br.readLine();
            String[] split = br.readLine().split(" ");

            for (int j = 0; j < split.length; j++) {
                scores[Integer.valueOf(split[j])] += 1;
            }

            int max = 0;
            int idx = 0;

            for (int j = 0; j <= 100; j++) {
                if (scores[j] >= max) {
                    max = scores[j];
                    idx = j;
                }
            }

            sb.append("#" + (i + 1) + " " + idx + "\n");
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
