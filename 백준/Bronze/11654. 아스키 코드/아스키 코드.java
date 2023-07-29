import java.io.*;

public class Main {

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        System.out.println(Integer.valueOf(string.charAt(0)));
    }
}