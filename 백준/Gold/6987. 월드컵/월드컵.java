import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX_TEAM_COUNT = 6;
    private static int[][] matches;
    private static boolean isFinished = false;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = 0;

        for (int i = 1; i < MAX_TEAM_COUNT; i++) {
            size += i;
        }

        matches = new int[size][2];
        int index = 0;
        for (int i = 0; i < MAX_TEAM_COUNT - 1; i++) {
            for (int j = i + 1; j < MAX_TEAM_COUNT; j++) {
                matches[index][0] = i;
                matches[index][1] = j;
                index++;
            }
        }

        int test = 4;
        while (test --> 0) {
            st = new StringTokenizer(br.readLine());
            int[][] game = new int[3][MAX_TEAM_COUNT];
            boolean isAvailable = true;

            for (int i = 0; i < MAX_TEAM_COUNT; i++) {
                int win = Integer.valueOf(st.nextToken());
                int draw = Integer.valueOf(st.nextToken());
                int lose = Integer.valueOf(st.nextToken());

                game[0][i] = win;
                game[1][i] = draw;
                game[2][i] = lose;

                if (win + draw + lose != 5) {
                    isAvailable = false;
                    break;
                }
            }

            if (isAvailable) {
                backTracking(game, 0, size);
                if (isFinished) {
                    sb.append(1);
                }
                else {
                    sb.append(0);
                }
            }
            else {
                sb.append(0);
            }

            sb.append(" ");
            isFinished = false;
        }

        System.out.print(sb);
    }

    private static void backTracking(int[][] game, int matchCount, int size) {
        if (isFinished) {
            return;
        }

        if (matchCount == size) {
            isFinished = true;
            return;
        }

        int myTeam = matches[matchCount][0];
        int enemyTeam = matches[matchCount][1];

        if (game[0][myTeam] > 0 && game[2][enemyTeam] > 0) {
            game[0][myTeam]--;
            game[2][enemyTeam]--;
            backTracking(game, matchCount + 1, size);
            game[0][myTeam]++;
            game[2][enemyTeam]++;
        }

        if (game[1][myTeam] > 0 && game[1][enemyTeam] > 0) {
            game[1][myTeam]--;
            game[1][enemyTeam]--;
            backTracking(game, matchCount + 1, size);
            game[1][myTeam]++;
            game[1][enemyTeam]++;
        }

        if (game[2][myTeam] > 0 && game[0][enemyTeam] > 0) {
            game[2][myTeam]--;
            game[0][enemyTeam]--;
            backTracking(game, matchCount + 1, size);
            game[2][myTeam]++;
            game[0][enemyTeam]++;
        }
    }
}