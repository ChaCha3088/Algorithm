import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Main {
    private static StringBuffer sb = new StringBuffer();
    private static List<String> list = new LinkedList<>();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        // KBS1
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("KBS1")) {
                for (int j = 0; j < i; j++) {
                    sb.append("1");
                }
                for (int j = 0; j < i; j++) {
                    sb.append("4");
                }

                String temp = list.get(i);
                list.remove(i);
                list.add(0, temp);
            }
        }

        // KBS2
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("KBS2")) {
                for (int j = 0; j < i; j++) {
                    sb.append("1");
                }
                for (int j = 0; j < i - 1; j++) {
                    sb.append("4");
                }

                String temp = list.get(i);
                list.remove(i);
                list.add(1, temp);
            }
        }

        // 출력
        System.out.println(sb);
    }
}