import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int shortest;
    private static int longest;
    private static char[] strArr;
    private static int[] countOfChars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            shortest = Integer.MAX_VALUE;
            longest = -1;

            String string = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            strArr = string.toCharArray();

            countOfChars = new int['z' - 'a' + 1];

            for (int j = 0; j < string.length(); j++) {
                countOfChars[strArr[j] - 'a'] += 1;
            }

            for (int j = 0; j < string.length(); j++) {
                if (countOfChars[strArr[j] - 'a'] < K) continue;

                int count = 1;
                for (int l = j + 1; l < string.length(); l++) {
                    if (strArr[j] == strArr[l]) {
                        count += 1;
                    }

                    if (count == K) {
                        shortest = Math.min(shortest, l - j + 1);
                        longest = Math.max(longest, l - j + 1);
                        break;
                    }
                }
            }

            if (shortest == Integer.MAX_VALUE || longest == -1) {
                System.out.println("-1");
            } else {
                System.out.println(shortest + " " + longest);
            }
        }
    }
}