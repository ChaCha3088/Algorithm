import java.util.*;

class Solution {
    private int [][] map;
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};
    private static int answer;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        
        for (int i = 0; i < rectangle.length; i++) {
            fill(2 * rectangle[i][0], 2 * rectangle[i][1], 2 * rectangle[i][2], 2 * rectangle[i][3]);
        }
        
        bfs(2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);
        
        return answer / 2;
    }
    
    private void bfs(int startx, int starty, int itemx, int itemy) {
        boolean[][] visited = new boolean[101][101];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startx);
        queue.add(starty);
        
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //범위 아웃
                if (!check(nx, ny)) {
                    continue; 
                }
                
                if (map[nx][ny] != 1 || visited[nx][ny]) {
                    continue;
                }
                
                //map[nx][ny]==2이고 방문한적없음
                map[nx][ny] = map[x][y] + 1;
                
                //목표점 도달
                if (nx == itemx & ny == itemy) { 
                    answer = (answer == 0) ? map[nx][ny] : Math.min(answer, map[nx][ny]);
                    continue;
                }
                visited[nx][ny] = true;
                
                queue.add(nx);
                queue.add(ny);
            }
        }
    }
    
    private boolean check(int x, int y) {
        if (x < 0 || y < 0 || x > 100 || y > 100) {
            return false;
        }
        return true;
    }
    
    private void fill(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 2) {
                    continue;
                }
                map[i][j] = 2;
                
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    map[i][j] = 1;
                }
            }
        }
    }
}