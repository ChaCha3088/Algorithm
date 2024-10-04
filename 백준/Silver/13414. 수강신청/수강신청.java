import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static int K, L;
    private static Map<String, Boolean> dict = new LinkedHashMap<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int l = 0; l < L; l++) {
            String line = br.readLine();

            if (dict.containsKey(line)) {
                dict.remove(line);

                dict.put(line, true);
            }
            else {
                dict.put(line, true);
            }
        }

        List<String> list = dict.keySet().stream().collect(Collectors.toList());

        for (int k = 0; k < K; k++) {
            if (k >= list.size()) {
                break;
            }
            
            sb.append(list.get(k)).append("\n");
        }

        System.out.println(sb);
    }
}