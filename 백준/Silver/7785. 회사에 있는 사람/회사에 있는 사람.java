import static java.util.Comparator.reverseOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static Set<String> set = new HashSet<>();

    // 현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String command = st.nextToken();

            if (command.equals("enter")) {
                set.add(name);
            }
            else if (command.equals("leave")) {
                set.remove(name);
            }
        }

        set.stream()
            .sorted(reverseOrder())
            .forEach((e) -> sb.append(e).append("\n"));

        System.out.println(sb);
    }
}