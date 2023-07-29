import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 S와 정수 i가 주어졌을 때, S의 i번째 글자를 출력
        String string = br.readLine();
        int i = Integer.valueOf(br.readLine());

        System.out.println(String.valueOf(string.charAt(i - 1)));
    }
}