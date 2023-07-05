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
		
		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		List<Integer> cards = new ArrayList();
		cards.add(0);
		for (int i = 1; i <= N; i++) {
			cards.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> students = new ArrayList();
		students.add(0);
		for (int i = 1; i <= N; i++) {
			students.add(i);
		}
		
		for (int i = 2; i <= N; i++) {
			int idx = students.indexOf(i);
			students.remove(idx);
			
			students.add(i - cards.get(i), i);
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(students.get(i)).append(" ");
		}

		//출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}
