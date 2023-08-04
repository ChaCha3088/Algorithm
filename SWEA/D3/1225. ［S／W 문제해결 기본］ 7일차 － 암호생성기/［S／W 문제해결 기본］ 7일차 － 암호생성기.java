import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	for (int test = 1; test <= 10; test++) {
    		br.readLine();
    		
    		String[] split = br.readLine().split(" ");
    		
    		Queue<Integer> queue = new LinkedList<>();
    		
    		for (int i = 0; i < 8; i++) {
    			queue.offer(Integer.parseInt(split[i]));
    		}
    		    		
    		while (true) {
    			boolean iteration = true;
    			
	    		for (int i = 1; i <= 5; i++) {
	    			int poll = queue.poll();
	    			
	    			int result = poll - i;
	    			
	    			if (result <= 0) {
	    				queue.offer(0);
	    				iteration = false;
	    				break;
	    			}
	    			
	    			queue.offer(result);
	    		}
	    		
	    		if (!iteration) {
    				break;
    			}
    		}
	    		
    		sb.append("#").append(test).append(" ");
    		
    		for (int i = 1; i <= 8; i++) {
    			sb.append(queue.poll()).append(" ");
    		}
    		
    		sb.append("\n");
    	}

        System.out.println(sb);
    }
}