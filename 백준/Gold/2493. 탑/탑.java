import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] towers = new int[N + 1];
        int[] result = new int[N + 1];
        // Double Ended Queue
        // LinkedList
        // 이유
        // 
        Deque<int[]> stack = new LinkedList<>();

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        int tower;
        for(int i = 1; i <= N; i++) {
            tower = towers[i];

            while(!stack.isEmpty()) {
                if(stack.peek()[1] > tower) {
                    break;
                }
                stack.pollFirst();
            }

            if(stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek()[0];
            }

            stack.addFirst(new int[] {i, tower});
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);
    }
}