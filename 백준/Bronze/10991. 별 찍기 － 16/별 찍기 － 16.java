import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        for (int i = 1; i <= N; i++) {
            // i - 1만큼 " ", i만큼 "*"
            String answer = "";

            for (int j = 0; j < N - i; j++) {
                answer += " ";
            }

            for (int j = 0; j < i; j++) {
                if (j != 0) {
                    answer += " ";
                }
                answer += "*";
            }
            System.out.println(answer);
        }
    }
}