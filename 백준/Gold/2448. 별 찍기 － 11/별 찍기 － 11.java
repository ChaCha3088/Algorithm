import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        List<String> string = new ArrayList<>();
        String inside = "  *  ";
        string.add(inside);

        inside = " * * ";
        string.add(inside);

        inside = "*****";
        string.add(inside);

        int current = 6;
        while (current <= N) {
            List<String> newString = new ArrayList<>();
            // current의 반만큼 공백 추가
            for (int i = 0; i < current / 2; i++) {
                String plus = "";
                for (int j = 0; j < current / 2; j++) {
                    plus += " ";
                }
                newString.add(plus + string.get(i) + plus);
            }

            //두번째 줄
            for (int i = 0; i < current / 2; i++) {
                newString.add(string.get(i) + " " + string.get(i));
            }

            string = newString;

            current *= 2;
        }

        for (String s : string) {
            System.out.println(s);
        }
    }
}