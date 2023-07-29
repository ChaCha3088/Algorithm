import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력

        int T = Integer.valueOf(br.readLine());

        for (int i = 0; i < T; i++) {
            String string = br.readLine();
            String answer = "";

            answer += string.substring(0, 1);
            answer += string.substring(string.length() - 1, string.length());

            System.out.println(answer);
        }
    }
}