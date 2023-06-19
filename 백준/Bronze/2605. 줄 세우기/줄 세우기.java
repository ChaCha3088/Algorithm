import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Integer> arr;
    private static List<Integer> numbers;
    private static int N;
    private static StringBuilder sb;
    private static boolean result;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new ArrayList();
        numbers = new ArrayList();

        arr.add(0);
        numbers.add(0);

        //입력
        for (int i = 1; i <= N; i++) {
            arr.add(i);
            numbers.add(sc.nextInt());
        }

        for (int i = 2; i <= N; i++) {
            int number = numbers.get(i);

            int idx = arr.indexOf(i);

            arr.remove(i);

            arr.add(idx - number, i);
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}