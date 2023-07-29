import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            String string = "";

            for (int j = 0; j < N - i - 1; j++) {
                string += " ";
            }

            for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                string += "*";
            }

            System.out.println(string);
        }
    }
}