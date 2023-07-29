import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        for (int i = 1; i <= N; i++) {
            String string = "";

            for (int j = 1; j <= i; j++) {
                string += "*";
            }

            for (int j = 1; j <= 2 * (N - i); j++) {
                string += " ";
            }

            for (int j = 1; j <= i; j++) {
                string += "*";
            }

            System.out.println(string);
        }

        for (int i = N - 1; i > 0; i--) {
            String string = "";

            for (int j = 1; j <= i; j++) {
                string += "*";
            }

            for (int j = 1; j <= 2 * (N - i); j++) {
                string += " ";
            }

            for (int j = 1; j <= i; j++) {
                string += "*";
            }

            System.out.println(string);
        }
    }
}