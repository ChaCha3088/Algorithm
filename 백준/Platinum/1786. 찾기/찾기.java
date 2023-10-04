import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static String T, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = br.readLine();
        P = br.readLine();

        int count = 0;

        // 접두사이면서 접미사인 최대 문자열의 길이 배열 만들기
        int[] KMPTable = new int[P.length()];

        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            // j가 1 이상이고(j가 0이고 문자가 다르면 다음으로 넘어가야 해서) 문자가 다르면
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                // 그 전까지 일치한 길이를 j로 설정
                j = KMPTable[j - 1];
            }

            // 문자가 같으면
            if (P.charAt(i) == P.charAt(j)) {
                KMPTable[i] = ++j;
            }
        }

        // 부분 일치 테이블 배열 만들기
        j = 0;

        for (int i = 0; i < T.length(); i++) {
            // 다를 때
            while (j > 0 && T.charAt(i) != P.charAt(j)) {
                j = KMPTable[j - 1];
            }

            // 같으면
            if (T.charAt(i) == P.charAt(j)) {
                if (j == P.length() - 1) {
                    count += 1;
                    sb.append(i - P.length() + 2).append(" ");
                    j = KMPTable[j];
                }
                // j를 늘린다.
                else {
                    j += 1;
                }
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}