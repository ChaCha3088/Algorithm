import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력
        System.out.println(br.readLine().length());
    }
}