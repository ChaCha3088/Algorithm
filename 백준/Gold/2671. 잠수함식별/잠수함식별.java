import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();

        boolean matches = Pattern.matches("(((100+)(1+))|01)+", string);

        if (matches) {
            System.out.println("SUBMARINE");
        }
        else {
            System.out.println("NOISE");
        }
    }
}