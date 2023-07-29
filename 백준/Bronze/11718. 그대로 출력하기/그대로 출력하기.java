import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받은 대로 출력

        while (true) {
            String string = br.readLine();

            if (string != null) {
                System.out.println(string);
            }
            else {
                break;
            }
        }
    }
}