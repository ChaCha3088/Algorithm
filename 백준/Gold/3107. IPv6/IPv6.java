import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        if (input.contains("::")) {
            input = input.replace("::", ":group:");
        }

        List<String> ipv6s = Stream.of(input.split(":")).collect(Collectors.toList());
        
        List<String> full = new ArrayList<>();
        for (int i = 0; i<ipv6s.size(); i++) {
            String string = ipv6s.get(i);

            if (string.isEmpty()) {
                continue;
            }

            while (string.length() < 4) {
                string = "0" + string;
            }

            full.add(string);
        }

        int groupLength = 8 - full.size() + 1;
        String[] answer = new String[8];
        int idx = 0;
        for (String ip : full) {
            if (ip.equals("group")) {
                while(groupLength-- > 0) {
                    answer[idx++] = "0000";
                }
            }
            else {
                answer[idx++] = ip;
            }
        }

        System.out.println(String.join(":", answer));
    }
}