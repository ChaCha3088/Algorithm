import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int w, h, p, q, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        int a = (p + t) / w;
        int b = (q + t) / h;

        int x, y;

        if (a % 2 == 0) {
            x = (p + t) % w;
        }
        else {
            x = w - (p + t) % w;
        }

        if (b % 2 == 0) {
            y = (q + t) % h;
        }
        else {
            y = h - (q + t) % h;
        }

        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(" ").append(y);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}