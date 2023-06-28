import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int K;
    private static int[][] arr = new int[7][2];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        //입력
        K = sc.nextInt();

        for (int i = 1; i <= 6; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        //최대값 위치 구하기
        int xMax = 0;
        int xLoc = 0;
        int yMax = 0;
        int yLoc = 0;

        for (int i = 1; i <= 6; i++) {
            if (arr[i][0] == 1 || arr[i][0] == 2) {
                if (xMax < arr[i][1]) {
                    xMax = arr[i][1];
                    xLoc = i;
                }
            }
            if (arr[i][0] == 3 || arr[i][0] == 4) {
                if (yMax < arr[i][1]) {
                    yMax = arr[i][1];
                    yLoc = i;
                }
            }
        }

        int xMinLoc = (xLoc + 3) % 6;
        if (xMinLoc == 0) {
            xMinLoc += 6;
        }

        int yMinLoc = (yLoc + 3) % 6;
        if (yMinLoc == 0) {
            yMinLoc += 6;
        }

        int xMin = arr[xMinLoc][1];
        int yMin = arr[yMinLoc][1];

        System.out.println(K * (xMax * yMax - xMin * yMin));
    }
}