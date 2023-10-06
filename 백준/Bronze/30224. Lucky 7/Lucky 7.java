import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int temp = N;

        List<Integer> numbers = new ArrayList<>();

        boolean isFound = false;
        while (temp > 0) {
            int div = temp % 10;
            if (div == 7) {
                isFound = true;
            }

            numbers.add(div);
            temp /= 10;
        }

        // 7 있을 때
        if (isFound) {
            // 나눌 수 있으면
            if (N % 7 == 0) {
                System.out.println(3);
            }
            else {
                System.out.println(2);
            }
        }
        else {
            // 나눌 수 있으면
            if (N % 7 == 0) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }

    }
}