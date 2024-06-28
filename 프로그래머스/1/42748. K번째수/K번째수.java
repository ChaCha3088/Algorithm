import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int where = 0;
        
        for (int i = 0; i < commands.length; i++) {
            int ii = commands[i][0];
            int jj = commands[i][1];
            int kk = commands[i][2];
            
            // 자르고
            int[] temp = new int[jj - ii + 1];
            int idx = 0;
            for (int j = ii - 1; j < jj; j++) {
                temp[idx] = array[j];
                idx += 1;
            }

            // 정렬
            Arrays.sort(temp);

            // 꺼내기
            answer[where] = temp[kk - 1];
            where += 1;
        }
        
        return answer;
    }
}