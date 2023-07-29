import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            String string = "";

            for (int j = 0; j < i; j++) {
                string += " ";
            }

            for (int j = 0; j < 2 * (N - i) - 1; j++) {
                string += "*";
            }

            System.out.println(string);
        }

        for (int i = 2; i <= N; i++) {
            String string = "";

            for (int j = N - i; j > 0; j--) {
                string += " ";
            }

            for (int j = 1; j < 2 * (i + 1) - 2; j++) {
                string += "*";
            }

            System.out.println(string);
        }
    }
}