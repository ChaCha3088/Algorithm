import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static List<int[]> whatToFill;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];

        whatToFill = new ArrayList();

        for (int i = 0; i < 9; i++) {
            String input = br.readLine();

            for (int j = 0; j < 9; j++) {
                map[i][j] = input.charAt(j) - '0';

                if (map[i][j] == 0) {
                    whatToFill.add(new int[] {i, j});
                }
            }
        }

        if (dfs(0)) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }

                sb.append("\n");
            }

            System.out.println(sb);
        }
    }

    private static boolean dfs(int depth) {
        if (whatToFill.size() == depth) {
            return true;
        }

        int x = whatToFill.get(depth)[0];
        int y = whatToFill.get(depth)[1];

        boolean[] numberUses = new boolean[10];

        // 가로
        for (int i = 0; i < 9; i++) {
            if (map[x][i] != 0) {
                numberUses[map[x][i]] = true;
            }
        }

        // 세로
        for (int i = 0; i < 9; i++) {
            if (map[i][y] != 0) {
                numberUses[map[i][y]] = true;
            }
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (map[i][j] != 0) {
                    numberUses[map[i][j]] = true;
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!numberUses[i]) {
                map[x][y] = i;
                boolean result = dfs(depth + 1);
                if (result) {
                    return true;
                }
                map[x][y] = 0;
            }
        }

        return false;
    }
}