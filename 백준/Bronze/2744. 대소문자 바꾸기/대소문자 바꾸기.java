import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력
        String answer = "";

        String[] split = br.readLine().split("");

        for (String s : split) {
            String lowerCase = s.toLowerCase();

            // 소문자라는 뜻
            if (lowerCase.equals(s)) {
                answer += s.toUpperCase();
            }
            // 대문자라는 뜻
            else {
                answer += lowerCase;
            }
        }

        System.out.println(answer);
    }
}