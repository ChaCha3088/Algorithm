import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(func(B));
    }

    private static long func(long input) {
        if (input == 1) {
            return A % C;
        }

        long result = func(input / 2) % C;

        // 짝수
        if (input % 2 == 0) {
            return result * result % C;
        }
        else {
            return result * result % C * A % C;
        }
    }
}