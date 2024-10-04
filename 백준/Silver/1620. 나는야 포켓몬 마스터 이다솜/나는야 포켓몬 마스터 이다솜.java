import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static int N, M;
    private static LinkedHashMap<String, Integer> dict = new LinkedHashMap<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int n = 0; n < N; n++) {
            String line = br.readLine();

            dict.put(line, n);
        }

        List<String> keys = dict.keySet().stream().collect(toList());

        for (int m = 0; m < M; m++) {
            String input = br.readLine();
            try {
                int number = Integer.parseInt(input);

                sb.append(keys.get(number - 1)).append("\n");

                continue;
            }
            catch (NumberFormatException e) {
            }

            sb.append(dict.get(input) + 1).append("\n");
        }

        System.out.println(sb);
    }
}