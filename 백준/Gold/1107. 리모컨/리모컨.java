import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int min = Integer.MAX_VALUE;
    private static String nString;
    private static Set<Character> available = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nString = br.readLine();
        N = Integer.parseInt(nString);
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            available.add((char) (i + '0'));
        }

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String s = st.nextToken();
                available.remove(s.charAt(0));
            }
        }

        min = Math.min(min, Math.abs(N - 100));

        if (!available.isEmpty()) {
            find("");
        }

        System.out.println(min);
    }

    private static void find(String string) {
        for (char str : available) {
            String temp = string + str;

            min = Math.min(min, Math.abs(N - Integer.parseInt(temp)) + temp.length());

            // 아직 다 안끝났으니까
            if (temp.length() < 6) {
                find(temp);
            }
        }
    }
}