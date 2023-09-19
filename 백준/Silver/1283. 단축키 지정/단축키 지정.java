import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] registered = new boolean['z' - 'a' + 1];

        String[] result = new String[N];

        for (int n = 1; n <= N; n++) {
            String string = br.readLine();
            result[n - 1] = string;

            String newString = string;

            String[] listOfString = newString.split(" ");

            boolean isFinished = false;

            for (int i = 0; i < listOfString.length; i++) {
                char firstCharacter = listOfString[i].toLowerCase().charAt(0);

                // 등록 안됐으면
                if (!registered[firstCharacter - 'a']) {
                    // 등록
                    registered[firstCharacter - 'a'] = true;

                    // 대괄호 추가
                    String right = listOfString[i].substring(1, listOfString[i].length());

                    listOfString[i] = "[" + listOfString[i].charAt(0) + "]" + right;

                    // 리스트에 업데이트
                    result[n - 1] = String.join(" ", listOfString);

                    // 끝
                    isFinished = true;
                    break;
                }
            }

            if (isFinished) {
                continue;
            }

            // 2
            for (int i = 0; i < newString.length(); i++) {
                newString = newString.toLowerCase();
                char c = newString.charAt(i);

                // 알파벳이고
                if ('a' <= c && c <= 'z') {
                    // 등록 안됐으면
                    if (!registered[c - 'a']) {
                        // 등록
                        registered[c - 'a'] = true;

                        // 대괄호 추가
                        String left = string.substring(0, i);
                        String target = string.substring(i, i + 1);
                        String right = string.substring(i + 1, string.length());

                        string = left + "[" + target + "]" + right;

                        // 리스트에 업데이트
                        result[n - 1] = string;

                        isFinished = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }
}