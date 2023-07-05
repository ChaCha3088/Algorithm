
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		List<Integer> input = new ArrayList();
		input.add(0);
				
		List<Integer> lst = new ArrayList();
		lst.add(0);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			lst.add(i);
			input.add(Integer.parseInt(st.nextToken()));
		}
		
		
		for (int i = 2; i <= N; i++) {
            int number = input.get(i);

            int idx = lst.indexOf(i);

            lst.remove(i);

            lst.add(idx - number, i);
        }
		
		for (int i = 1; i <= N; i++) {
			sb.append(lst.get(i)).append(" ");
		}
		
		//출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}
