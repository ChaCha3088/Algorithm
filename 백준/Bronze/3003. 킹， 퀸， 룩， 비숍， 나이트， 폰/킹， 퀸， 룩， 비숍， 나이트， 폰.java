import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");

        Integer[] info = {1, 1, 2, 2, 2, 8};
        Integer[] input = new Integer[6];
        Integer[] answer = new Integer[6];

        for (int i = 0; i < 6; i++) {
            input[i] = Integer.parseInt(string[i]);
        }

        for (int j = 0; j < 6; j++) {
            answer[j] = info[j] - input[j];
        }

        for (int j = 0; j < 6; j++) {
            System.out.print(answer[j]+" ");
        }

    }
}