import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int width, height;
    private static int N;
    private static int[][] stores;
    private static int[] dongGun;
    private static int half;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        //입력
        width = sc.nextInt();
        height = sc.nextInt();

        N = sc.nextInt();
        stores = new int[N + 2][2];
        for (int i = 1; i <= N + 1; i++) {
            stores[i][0] = sc.nextInt();
            stores[i][1] = sc.nextInt();

            //가게가 북쪽이면
            if (stores[i][0] == 1) {
                stores[i][0] = stores[i][1];
            }
            //남쪽이면
            else if (stores[i][0] == 2) {
                stores[i][0] = 2 * width - stores[i][1] + height;
            }
            //서쪽이면
            else if (stores[i][0] == 3) {
                stores[i][0] = 2 * height - stores[i][1] + 2 * width;
            }
            //동쪽이면
            else if (stores[i][0] == 4) {
                stores[i][0] = width + stores[i][1];
            }
        }

        dongGun = stores[N + 1];

        half = width + height;

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += findShortCut(i);
        }

        System.out.println(sum);
    }

    private static int findShortCut(int idx) {
        int store[] = stores[idx];

        int result = Math.abs(store[0] - dongGun[0]);

        if (result > half) {
            result = 2 * half - result;
        }

        return result;
    }
}