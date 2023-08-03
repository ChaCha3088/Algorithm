import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int S = Integer.parseInt(s[0]);
        int P = Integer.parseInt(s[1]);

        String string = br.readLine();

        String[] minimum = br.readLine().split(" ");

        int A = Integer.parseInt(minimum[0]), C = Integer.parseInt(minimum[1]), G = Integer.parseInt(minimum[2]), T = Integer.parseInt(minimum[3]);
        
        int left = 0;

        int answer = 0;

        Queue<Character> characters = new LinkedList<>();
        int ACount = 0, CCount = 0, GCount = 0, TCount = 0;
        for (int i = left; i < left + P; i++) {
            char character = string.charAt(i);

            if (character == 'A') {
                ACount += 1;
            }
            else if (character == 'C') {
                CCount += 1;
            }
            else if (character == 'G') {
                GCount += 1;
            }
            else if (character == 'T') {
                TCount += 1;
            }

            characters.offer(character);
        }
        
        while (true) {
            if (ACount >= A && CCount >= C && GCount >= G && TCount >= T) {
                answer += 1;
            }

            if (left + P >= S) {
                break;
            }

            Character poll = characters.poll();

            if (poll == 'A') {
                ACount -= 1;
            }
            else if (poll == 'C') {
                CCount -= 1;
            }
            else if (poll == 'G') {
                GCount -= 1;
            }
            else if (poll == 'T') {
                TCount -= 1;
            }

            char newChar = string.charAt(left + P);
            characters.offer(newChar);

            if (newChar == 'A') {
                ACount += 1;
            }
            else if (newChar == 'C') {
                CCount += 1;
            }
            else if (newChar == 'G') {
                GCount += 1;
            }
            else if (newChar == 'T') {
                TCount += 1;
            }

            left += 1;
        }

        System.out.println(answer);
    }
}